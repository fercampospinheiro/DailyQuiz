package br.com.sidlar.dailyquiz.presentation.cadastroMembro;

import org.springframework.validation.BindingResult;

/**
 * @author Fernando de Campos Pinheiro
 */
public class ValidaNome {
    private static final String CAMPO_NOME = "nome";

    /**
     * Se o nome for maior que 50 caracteres ou não informado lança uma execeção com a descrição do erro
     */
    public void valida(String nome, BindingResult resultado) {
        if (nome.length() > 50){
            resultado.rejectValue(CAMPO_NOME,"resultado", "Nome com mais 50 caracteres !");
            throw new DadosInvalidosException("Nome possui mais de 50 cacteres !");
        }
        else if(nome.isEmpty()){
            resultado.rejectValue(CAMPO_NOME,"resultado", "O nome não foi informado!");
            throw new DadosInvalidosException("Nome não informado !");
        }
    }
}
