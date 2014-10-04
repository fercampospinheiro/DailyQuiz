package br.com.sidlar.dailyquiz.infrastructure;
import org.springframework.stereotype.Component;

import static org.apache.commons.codec.digest.DigestUtils.*;

/**
 * Implementação para a geração de HashCode do tipo Sha1
 * @author Fernando de Campos Pinheiro
 */

@Component
public class HashcodeSha1 implements GeradorHashcode {

	@Override
	public String geraHashcode(String texto) {
		return sha1Hex(texto);

	}
}
