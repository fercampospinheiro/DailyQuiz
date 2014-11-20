package br.com.sidlar.dailyquiz.domain.respostaQuestionario;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.Questionario;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.QuestionarioRepository;
import br.com.sidlar.dailyquiz.domain.formularios.FormularioQuestionario;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.membro.MembroRepository;

@Component
public class RespostaQuestionarioFactory {
	
	@Autowired
	private QuestionarioRepository repository;
	@Autowired
	private MembroRepository membroRepository;
	
	public RespostaQuestionarioFactory() {
	}
	
	public RespostaQuestionario criaPorFormulario(FormularioQuestionario formulario){
		Questionario questionario = repository.buscaQuestionarioPorId(formulario.getIdRespostaQuestionario());
		Membro membro = membroRepository.buscaPorId(formulario.getIdMembro());
		RespostaQuestionario  resposta = new RespostaQuestionario(questionario);
		resposta.defineDataReposta(LocalDate.now());
		resposta.respondidoPor(membro);
		return resposta;
	}
	
	
	
}
