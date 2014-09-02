package br.com.sidlar.dailyquiz.domain;
import static org.apache.commons.codec.digest.DigestUtils.*;

/**
 * Classe geradora de hascode
 * @author Fernando de Campos Pinheiro
 */
public class GeradorHashcode {

    public String geraHashCodeDeString(String senha){
		return sha1Hex(senha);
    }
}
