package br.com.sidlar.dailyquiz.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviço de suporte ao cadastro de um membro
 * @author  Fernando de Campos Pinheiro
 */

@Service
public class CadastroMembroService {


	/**
	 * Serviço que verifica o nivel de segurança da senha no cadastro de membro
	 * @param senha
	 * @return NivelSeguranca
	 */
	public NivelSeguranca obtemNivelDeSegurancaDaSenhaDoMebro(String senha){

		return NivelSeguranca.MEDIO;
	}

}
