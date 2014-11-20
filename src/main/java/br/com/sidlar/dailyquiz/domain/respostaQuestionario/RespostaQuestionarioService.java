package br.com.sidlar.dailyquiz.domain.respostaQuestionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaQuestionarioService {
	@Autowired
	private RespostaQuestionarioRepository repository;
	
	public void respondeQuestionario(RespostaQuestionario resposta){
		repository.salva(resposta);
	}
}
