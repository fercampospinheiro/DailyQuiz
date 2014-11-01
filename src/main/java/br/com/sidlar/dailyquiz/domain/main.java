package br.com.sidlar.dailyquiz.domain;

import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Alternativa;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questao;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questionario;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaDaQuestao;
import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaDoQuestionario;

public class main {

	
	public static void main(String[] args) {

		//Crio Questionario
		Questionario questionario = new Questionario("Perguntas da Bíblia");

			//Criar questao
			Questao questao = new Questao("Quem foi João na Bíblia");

				//Primeira Alternativa
				Alternativa alternativa = new Alternativa("O meu Vizinho");
				questao.adicionaAlternativa(alternativa);
				//Segunda Alternativa
				Alternativa alternativa2 = new Alternativa("O Pai de Jesus");
				questao.adicionaAlternativa(alternativa2);
				//Terceira Alternativa
				Alternativa alternativa3 = new Alternativa("Um apóstolo");
				questao.defineAlternativaCorreta(alternativa3);

		//Adicionar questões ao questionário
		questionario.adicionaQuestao(questao);

		//Tornar Membro
		Membro membro = new Membro();

		//Responder Questionario
		RespostaDoQuestionario respostaDoQuestionario = new RespostaDoQuestionario(questionario);
		//Responder questoes
		RespostaDaQuestao respostaDaQuestao = new RespostaDaQuestao(questao);
		//Qual alternativa respondida de uma questa
		respostaDaQuestao.is(alternativa3);


		//Adiciona resposta da Questao ao questionario respondido
		respostaDoQuestionario.adicionaRespostaDaQuestao(respostaDaQuestao);

		respostaDoQuestionario.respondidoPor(membro);

		membro.adicionaRespostaQuestionario(respostaDoQuestionario);

		//Verifica se questao esta correta
		System.out.println(questao.exibe());
		System.out.println(respostaDaQuestao.exibe());
		System.out.println( respostaDaQuestao.estaCorreta());

	}
}
