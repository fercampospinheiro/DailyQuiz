package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario;

import br.com.sidlar.dailyquiz.domain.excecoes.QuestaoRepetidaException;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import com.google.common.collect.Lists;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

@Entity
public class Questionario {
	@Id @GeneratedValue
	private Integer id;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idQuestionario")
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

	private void disponivelAhPartirDe(DateTime dataDisponivel){
		this.dataDisponivel = dataDisponivel;
	}

	private void acessivelAte(DateTime dataLimite){
		this.dataLimite = dataLimite;
	}

}
