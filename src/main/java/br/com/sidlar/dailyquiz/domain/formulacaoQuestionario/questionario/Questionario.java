package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario;

import br.com.sidlar.dailyquiz.domain.excecoes.QuestaoRepetidaException;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao.Questao;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import com.google.common.collect.Lists;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.Period;
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

	private void  criadoPor(Membro membro){
		this.membroCriador = membro;
	}

	private void disponivelAhPartirDe(DateTime dataDisponivel) {
		if (dataDisponivel.isAfter(dataLimite) && dataDisponivel == null || dataLimite == null && dataDisponivel == null){
			this.dataDisponivel = dataDisponivel;
		}
		else {
			throw new IllegalArgumentException("Data disponivel informada é maior que data limite ou já informada!");
		}
	}

	private void acessivelAte(DateTime dataLimite) {
		if (dataLimite.isBefore( dataDisponivel) && dataLimite == null) {
			this.dataLimite = dataLimite;
		} else {
			throw new IllegalArgumentException("Data Limite informada é menor que data disponive ou  já informada!");
		}
	}

	public String expiraEm(){

		PeriodFormatter periodFormat = new PeriodFormatterBuilder()
				.appendDays()
				.appendSuffix(" dias ")
				.appendHours()
				.appendSuffix(" horas ")
				.appendMinutes()
				.appendSuffix(" minutos ")
				.toFormatter();
		Period prazoExpiracao =  new Period(dataDisponivel,dataLimite);
		return periodFormat.print(prazoExpiracao);
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


