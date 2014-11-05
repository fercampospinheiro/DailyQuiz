package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario;

import br.com.sidlar.dailyquiz.domain.excecoes.QuestaoRepetidaException;
import com.google.common.collect.Lists;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Questionario {
	@Id
	private Integer id;
	@OneToMany
	@JoinColumn(name = "idQuestionario",referencedColumnName = "id")
	private List<Questao> questoes = Lists.newArrayList();
	private String nome;
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataDisponivel;
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dataLimite;

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



}
