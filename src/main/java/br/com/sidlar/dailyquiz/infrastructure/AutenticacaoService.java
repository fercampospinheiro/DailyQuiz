package br.com.sidlar.dailyquiz.infrastructure;

import br.com.sidlar.dailyquiz.domain.Membro;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author  Fernando de Campos Pinheiro
 */
@Service
public class AutenticacaoService {

	private void autenticaMembro(Membro membro, HttpSession session){
		session.getAttribute("MembroAutenticado");
	}
}
