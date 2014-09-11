package br.com.sidlar.dailyquiz.infrastructure;

import br.com.sidlar.dailyquiz.domain.Membro;
import org.joda.time.DateTime;

/**
 * @author  Fernando de Campos Pinheiro
 */
public class DadosDeAutenticação {

	private Membro membro;
	private DateTime momentoDaAutenticacao;

	public DadosDeAutenticação(Membro membro, DateTime momentoDaAutenticacao) {
		this.membro = membro;
		this.momentoDaAutenticacao = momentoDaAutenticacao;
	}
}
