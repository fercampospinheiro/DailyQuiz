package br.com.sidlar.dailyquiz.domain.excecoes;

import javax.persistence.NoResultException;

/**
 * Created by fernando on 04/10/14.
 */
public class EmailInexistenteException extends NoResultException {

    public EmailInexistenteException() {
    }

    public EmailInexistenteException(String message) {
        super(message);
    }
}
