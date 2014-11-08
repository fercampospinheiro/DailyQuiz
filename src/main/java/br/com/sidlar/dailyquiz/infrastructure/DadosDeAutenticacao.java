package br.com.sidlar.dailyquiz.infrastructure;

import br.com.sidlar.dailyquiz.domain.membro.Membro;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * @author  Fernando de Campos Pinheiro
 */
public class DadosDeAutenticacao {

	private Membro membro;
	private DateTime momentoDaAutenticacao;

	public DadosDeAutenticacao(Membro membro, DateTime momentoDaAutenticacao) {
		this.membro = membro;
		this.momentoDaAutenticacao = momentoDaAutenticacao;
	}

	public Membro getMembro() {
		return membro;
	}

}
