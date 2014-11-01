package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario;

import br.com.sidlar.dailyquiz.domain.excecoes.QuestaoRepetidaException;
import com.google.common.collect.Lists;

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
	@JoinColumn(name = "questionario_id",referencedColumnName = "id")
	private List<Questao> questoes = Lists.newArrayList();
	private String descricao;

	public Questionario() {
	}

	public Questionario(String descricao) {
		this.descricao = descricao;
	}

	public void adicionaQuestao(Questao questao) {
		if (!questoes.contains(questao)) {
			this.questoes.add(questao);
		} else {
			throw new QuestaoRepetidaException("Questao Repetida! Informe outra questão!");
		}

	}



}
