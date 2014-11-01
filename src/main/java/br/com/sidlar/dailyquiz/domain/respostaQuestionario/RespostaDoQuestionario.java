package br.com.sidlar.dailyquiz.domain.respostaQuestionario;

import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questionario;
import com.google.common.collect.Lists;
import org.hibernate.annotations.Type;
import org.hibernate.engine.internal.JoinSequence;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Fernando de Campos Pinheiro
 */
@Entity
public class RespostaDoQuestionario {
    @Id
    private Integer id;
    @OneToOne
    private Questionario questionario;
    @OneToMany
    @JoinColumn(name ="respostaQuestionario_id")
    private List<RespostaDaQuestao> respostas = Lists.newArrayList();
    @OneToOne
    private Membro membro;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate dataReposta;

    public RespostaDoQuestionario() {
    }

    public void adicionaRespostaDaQuestao(RespostaDaQuestao respostaDaQuestao){
      
    }

    public RespostaDoQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public void respondidoPor(Membro membro){
        this.membro =  membro;
    }

    public void adicionaQuestionario(Questionario questionario){
        questionario = questionario;
    }



}
