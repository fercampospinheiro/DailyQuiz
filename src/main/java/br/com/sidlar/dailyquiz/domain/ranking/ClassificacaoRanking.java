package br.com.sidlar.dailyquiz.domain.ranking;

import java.util.List;
import java.util.Map;

/**
 * @autor Fernando de Campos Pinheiro
 */
public interface ClassificacaoRanking {
    List<Posicao> classifica(List<ItemRanking> itensItemRanking);
}
