package br.com.sidlar.dailyquiz.infrastructure;
import org.springframework.stereotype.Component;

import static org.apache.commons.codec.digest.DigestUtils.*;

/**
 * Classe geradora de hascode
 * @author Fernando de Campos Pinheiro
 */

@Component
public class  HashcodeSha1 implements GeradorHascode {

	@Override
	public String geraHashcode(String texto) {
		return sha1Hex(texto);

	}
}
