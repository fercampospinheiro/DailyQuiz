package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario;

import br.com.sidlar.dailyquiz.domain.excecoes.QuestaoRepetidaException;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao.Questao;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import com.google.common.collect.Lists;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.convert.PeriodConverter;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
public class Questionario {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idQuestionario")
    @OrderColumn(name = "ordem")
	private List<Questao> questoes = Lists.newArrayList();

	private String nome;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataDisponivel;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataLimite;

	@OneToOne
	@JoinColumn(name = "idMembroCriador")
	private Membro membroCriador;

    public Questionario() {
	}

	public Questionario(String nome) {
		this.nome = nome;
	}

	public void adicionaQuestao(Questao questao) {
		if (!questoes.contains(questao)) {
			this.questoes.add(questao);
		} else {
			throw new QuestaoRepetidaException("Questao Repetida! Informe outra questão!");
		}

	}

	public void  criadoPor(Membro membro){
		this.membroCriador = membro;
	}

	public void disponivelAhPartirDe(DateTime dataDisponivel) {
		if (dataDisponivel.isAfter(dataLimite)){
			this.dataDisponivel = dataDisponivel;
		}
		else {
			throw new IllegalArgumentException("Data disponivel informada é maior que data limite ou já informada!");
		}
	}

	public void acessivelAte(DateTime dataLimite) {
		if (dataLimite.isBefore( dataDisponivel)) {
			this.dataLimite = dataLimite;
		} else {
			throw new IllegalArgumentException("Data Limite informada é menor que data disponivel ou  já informada!");
		}
	}

	public String expiraEm(){
		Period prazoExpiracao =  new Period(dataDisponivel,dataLimite);

		if(possuiDias(prazoExpiracao)) {
			return obtemDias(prazoExpiracao);
		}
		else if (possuiHorasEhMinutos(prazoExpiracao)) {
			return prazoExpiracao.getHours() + " horas e " + prazoExpiracao.getMinutes() + " minutos";
		} else {
			return prazoExpiracao.getHours() + " horas e " + prazoExpiracao.getMinutes() + " minut";
		}

		}

	private boolean possuiDias(Period periodo){
		return periodo.getDays() > 0;
	}
	private String obtemDias(Period periodo){
		return periodo.getDays() + " dias";
	}

	private boolean possuiHorasEhMinutos(Period periodo){
		return periodo.getHours() >= 1 && periodo.getMinutes() >=1;
	}

	public String getNome() {
		return nome;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public Integer getId() {
		return id;
	}
}


