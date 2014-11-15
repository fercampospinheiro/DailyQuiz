package br.com.sidlar.dailyquiz.domain.respostaQuestionario;

import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questao;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questionario;
import com.google.common.collect.Lists;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.List;

/**
 * @author Fernando de Campos Pinheiro
 */
@Entity
public class RespostaQuestionario {
    @Id
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "idQuestionario")
    private Questionario questionario;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name ="idRespostaQuestionario")
    private List<RespostaQuestao> respostaQuestoes = Lists.newArrayList();
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="idMembro")
    private Membro membro;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate dataReposta;
    @Column(name = "qtdAcertos")
    private Integer numeroAcertos;

    public RespostaQuestionario() {}

    private void adicionaOpcoesRespostas(){
      for(Questao questao : questionario.getQuestoes()){
          RespostaQuestao respostaQuestao = new RespostaQuestao(questao);
          respostaQuestoes.add(respostaQuestao);
      }
    }

    public RespostaQuestionario(Questionario questionario) {
        this.questionario = questionario;
        adicionaOpcoesRespostas();
    }

    public void calculaAcertos(){
        for(RespostaQuestao resposta : respostaQuestoes  ){
            if(resposta.estaCorreta()){
                numeroAcertos =+ 1;
            }

        }
    }

    public void respondidoPor(Membro membro){
        this.membro =  membro;
    }

    public void adicionaQuestionario(Questionario questionario){
        questionario = questionario;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public Membro getMembro() {
        return membro;
    }

    public List<RespostaQuestao> getRespostaQuestoes() {
        return respostaQuestoes;
    }
}

