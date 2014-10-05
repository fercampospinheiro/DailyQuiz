package br.com.sidlar.dailyquiz.infrastructure;
import org.springframework.stereotype.Component;

import static org.apache.commons.codec.digest.DigestUtils.*;

/**
 * Implementação para a geração de HashCode do tipo Sha1
 * @author Fernando de Campos Pinheiro
 */

@Component
public class HashSha1 implements GeradorHash {

	@Override
	public String geraHash(String texto) {
		return sha1Hex(texto);

	}
}
