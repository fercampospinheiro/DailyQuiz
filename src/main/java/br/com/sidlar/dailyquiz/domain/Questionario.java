package br.com.sidlar.dailyquiz.domain;

import java.util.HashMap;
import java.util.Map;


public class Questionario {

	private Long id;
	private Map<Integer, Questao> questoes = new HashMap<>();
	private String descricao;

	public Questionario() {
	}

	public Questionario(String descricao) {
		this.descricao = descricao;
	}

	public void adicionaQuestao(Integer numero,Questao questao){
		this.questoes.put(numero,questao);
	}
	
	public Questao obtemQuestaoPorNumero(Integer numero){
		return this.questoes.get(numero);
	}


}
