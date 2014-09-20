package br.com.sidlar.dailyquiz.infrastructure;

import br.com.sidlar.dailyquiz.domain.Membro;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 * @author  Fernando de Campos Pinheiro
 */
public class DadosDeAutenticação {

	private Membro membro;
	private DateTime momentoDaAutenticacao;
	private boolean ehDiaDeAniversario;
	private Days diasParaProximoAniversario;

	public DadosDeAutenticação(Membro membro, DateTime momentoDaAutenticacao) {
		this.membro = membro;
		this.momentoDaAutenticacao = momentoDaAutenticacao;
		verificaAniversario(momentoDaAutenticacao.toLocalDate());
	}

	public Membro getMembro() {
		return membro;
	}

	public boolean isDiaDeAniversario() {
		return ehDiaDeAniversario;
	}

	public Days getDiasParaProximoAniversario() {
		return diasParaProximoAniversario;
	}

	private void verificaAniversario(LocalDate diaDaAutenticacao){
		this.ehDiaDeAniversario = membro.eHDiaDoAniversario(diaDaAutenticacao);
	}

	private void diasParaProximoAniversario(){
        diasParaProximoAniversario = membro.diasRestantesParaProximoAniversario();
    }



}
