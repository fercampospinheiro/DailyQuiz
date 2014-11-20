package br.com.sidlar.dailyquiz.domain.formularios;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;

import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questao;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questionario;
import com.google.common.collect.Sets;

public class FormularioQuestionario {
	private Integer idRespostaQuestionario;
	private Questionario questionario;
	private Set<FormularioQuestao> questoes = Sets.newHashSet();
	private Integer idMembro;
	
	public FormularioQuestionario() {}
	
	public FormularioQuestionario(Questionario questionario) {
		this.questionario = questionario;
		this.adicionaQuestoes();
	}
	
	public Questionario getQuestionario() {
		return questionario;
	}
	
	public Set<FormularioQuestao> getQuestoes() {
		return questoes;
	}
	
	
	public Integer getIdRespostaQuestionario() {
		return idRespostaQuestionario;
	}

	public void setIdRespostaQuestionario(Integer idRespostaQuestionario) {
		this.idRespostaQuestionario = idRespostaQuestionario;
	}

	private void adicionaQuestoes(){
		Set<Questao> questoes = this.questionario.getQuestoes();
		for (Questao questao : questoes) {
			this.questoes.add(new FormularioQuestao(questao));
		}
	}

	public Integer getIdMembro() {
		return idMembro;
	}

	public void setIdMembro(Integer idMembro) {
		this.idMembro = idMembro;
	}

	
}
