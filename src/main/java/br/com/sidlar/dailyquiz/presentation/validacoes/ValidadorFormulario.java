package br.com.sidlar.dailyquiz.presentation.validacoes;

import br.com.sidlar.dailyquiz.domain.formularios.FormularioMembro;
import br.com.sidlar.dailyquiz.presentation.excecoes.DadosInvalidosException;
import org.springframework.validation.BindingResult;

/**
 * Responśavel pela pré-validação dos dados do formulario com propósito
 * de cadastro de um novo membro
 * @author Fernando de Campos Pinheiro
 */
public class ValidadorFormulario {


    private BindingResult resultado;
    private FormularioMembro formulario;
    private ValidaEmail email = new ValidaEmail();
    private ValidaNome nome = new ValidaNome();
    private ValidaSenha senha = new ValidaSenha();

    public ValidadorFormulario( FormularioMembro formulario,BindingResult resultado){
        this.resultado = resultado;
        this.formulario = formulario;
    }

    public void validaCampos() throws DadosInvalidosException{
        email.valida(formulario.getEmail(),resultado);
        nome.valida(formulario.getNome(),resultado);
        senha.valida(formulario.getSenha(),resultado);
    }


}
