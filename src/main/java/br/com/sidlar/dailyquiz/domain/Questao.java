package br.com.sidlar.dailyquiz.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Questao {

	private String pergunta;
	private Map<Opcao,Alternativa> alternativas = new HashMap<>();
	private Opcao opcaoCorreta;

	public Questao() {
	}

	public Questao(String pergunta) {
		this.pergunta = pergunta;
	}

	public void formulaPergunta(String pergunta){
		this.pergunta = pergunta;
	}
	
	public void adicionaAlternativa(Opcao opcao,Alternativa alternativa){
		alternativas.put(opcao,alternativa);
	}
	public String getPergunta() {
		return pergunta;
	}

	public void defineAlternativaCorreta(Opcao opcao){
		opcaoCorreta = opcao;
	}

	public Alternativa getAlternativa(Opcao opcao){
		return alternativas.get(opcao);
	}

	public boolean altertivaCorretaEhIgualOpcao(Opcao opcao){
		return opcaoCorreta == opcao;
	}


}
