package br.com.sidlar.dailyquiz.domain.respostaQuestionario;

import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.alternativa.Alternativa;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.alternativa.AlternativaRepository;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao.Questao;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao.QuestaoRepository;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario.Questionario;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario.QuestionarioRepository;
import br.com.sidlar.dailyquiz.presentation.formularios.FormularioQuestao;
import com.google.common.collect.Lists;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sidlar.dailyquiz.presentation.formularios.FormularioQuestionario;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.membro.MembroRepository;

import java.util.List;

@Component
public class RespostaQuestionarioFactory {
	
	@Autowired private QuestionarioRepository repository;
	@Autowired private QuestaoRepository questaoRepository;
	@Autowired private AlternativaRepository alternativaRepository;
	@Autowired private MembroRepository membroRepository;
	public RespostaQuestionarioFactory() {}
	
	public RespostaQuestionario criaPorFormulario(FormularioQuestionario formulario){

		List<FormularioQuestao> formulariosDasQuestoes = formulario.getFormularioQuestoes();
		List<RespostaQuestao> respostas = obtemRespostas(formulariosDasQuestoes);
		RespostaQuestionario respostaQuestionario = obtemRespostaDoQuestionario(formulario);
		respostaQuestionario.adicionaRespostas(respostas);
		return respostaQuestionario;
	}

	private RespostaQuestionario obtemRespostaDoQuestionario(FormularioQuestionario formulario){
		Integer idRespostaQuestionario = formulario.getIdRespostaQuestionario();
		Integer idMembro = formulario.getIdMembro();

		Questionario questionario = repository.buscaQuestionarioPorId(idRespostaQuestionario);
		Membro membro = membroRepository.buscaPorId(idMembro);

		RespostaQuestionario  respostaQuestionario = new RespostaQuestionario();
		respostaQuestionario.referenteAo(questionario);
		respostaQuestionario.feitoNaData(LocalDate.now());
		respostaQuestionario.respondidoPor(membro);

		return respostaQuestionario;
	}

	private List<RespostaQuestao> obtemRespostas(List<FormularioQuestao> formulariosQuestoes){
		List<RespostaQuestao> respostasDasQuestoes = Lists.newArrayList();

		for(FormularioQuestao formularioQuestao : formulariosQuestoes){

			Integer idQuestao = formularioQuestao.getIdRepostaQuestao();
			Questao questao = questaoRepository.buscaPorId(idQuestao);

			RespostaQuestao resposta = new RespostaQuestao();
			resposta.referenteA(questao);
			Alternativa alternativa = obtemAlternativaSelecionada(formularioQuestao);
			resposta.comAlternativaSelecionada(alternativa);

			respostasDasQuestoes.add(resposta);
		}
		return respostasDasQuestoes;
	}

	private Alternativa obtemAlternativaSelecionada(FormularioQuestao formularioQuestao){
		Integer idAlternativaSelecionada = formularioQuestao.getIdAlternativa();
		Alternativa alternativaSelecionada =  alternativaRepository.buscaPorId(idAlternativaSelecionada);
		return  alternativaSelecionada;
	}

	
}
