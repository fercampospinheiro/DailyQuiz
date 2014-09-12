package br.com.sidlar.dailyquiz.infrastructure;

import org.springframework.stereotype.Component;

/**
 * @author  Fernando de Campos Pinheiro
 */

public interface GeradorHascode {

	public String geraHashcode(String texto);
}
