package br.com.sidlar.dailyquiz.domain;

public class main {

	
	public static void main(String[] args) {

		//Crio Questionario
		Questionario questionario = new Questionario("Perguntas da Bíblia");

		//Primeira questao
		Questao questao = new Questao("Quem foi João na Bíblia");

		questao.formulaPergunta("Quantos livros tem a Biblia?");
		questao.adicionaAlternativa(Opcao.A, new Alternativa("67"));
		questao.adicionaAlternativa(Opcao.B, new Alternativa("66"));
		questao.adicionaAlternativa(Opcao.C,new Alternativa("68"));
		questao.defineAlternativaCorreta(Opcao.B);

		questionario.adicionaQuestao(2,questao);

		//Respostas ao questionario


		RespostaQuestionario respostaQuestionario = new RespostaQuestionario(questionario);
		respostaQuestionario.respondidoPor(new Membro());

		RespostaQuestao respostaQuestao = new RespostaQuestao(2,questao);
		respostaQuestao.is(Opcao.B);

		respostaQuestionario.adicionaRespostaDaQuestao(respostaQuestao);

		System.out.println(respostaQuestao.visualizaPergunta());
		System.out.println(respostaQuestao.visualiaResposta());
		System.out.println(respostaQuestao.estaCorreta());


	}
}
