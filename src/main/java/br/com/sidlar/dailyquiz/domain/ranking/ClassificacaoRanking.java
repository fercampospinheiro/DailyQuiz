package br.com.sidlar.dailyquiz.domain.ranking;

import java.util.List;

/**
 * @autor Fernando de Campos Pinheiro
 */
public interface ClassificacaoRanking {
    List<Posicao> classifica(List<Posicao> posicoes);
}
