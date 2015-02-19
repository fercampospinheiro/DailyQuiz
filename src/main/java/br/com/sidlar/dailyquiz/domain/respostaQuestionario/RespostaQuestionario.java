package br.com.sidlar.dailyquiz.domain.respostaQuestionario;

import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario.Questionario;
import com.google.common.collect.Lists;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Fernando de Campos Pinheiro
 */
@Entity
public class RespostaQuestionario {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    @JoinColumn(name = "idQuestionario")
    private Questionario questionario;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRespostaQuestionario",nullable = false)
    @OrderColumn(name = "ordem")
    private List<RespostaQuestao> respostaQuestoes = Lists.newArrayList();

    @OneToOne
    @JoinColumn(name="idMembro")
    private Membro membro;

    @Column(name = "data")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate dataReposta;

    private long pontuacao = 0;

    public long getPontuacao() {
        return this.pontuacao;
    }

    private void calculaPontuacao(){
        for(RespostaQuestao respostaQuestao : this.respostaQuestoes){
            if(respostaQuestao.estaCorreta()) this.pontuacao++;
        }
    }

    public RespostaQuestionario() {}

    public void referenteAo(Questionario questionario){
        this.questionario = questionario;
    }

    public void respondidoPor(Membro membro){
        this.membro =  membro;
    }

    public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public Questionario getQuestionario() {
        return questionario;
    }

    public Membro getMembro() {
        return membro;
    }

    public List<RespostaQuestao> getRespostaQuestoes() {
        return this.respostaQuestoes;
    }
    
    public void feitoNaData(LocalDate dataReposta){
    	this.dataReposta = dataReposta;
    }

    public void adicionaRespostas(List<RespostaQuestao> respostas){
        this.respostaQuestoes = respostas;
        calculaPontuacao();
    }

    public Integer getId() {
        return id;
    }

    public String getDataReposta() {
        DateTimeFormatter formataDaDate =  DateTimeFormat.forPattern("dd/MM/yyyy");
        return dataReposta.toString(formataDaDate);
    }
}

