package br.com.sidlar.dailyquiz.presentation.cadastroMembro;

import org.springframework.validation.BindingResult;

/**
 * Responśavel pela pré-validação dos dados do formulario com propósito
 * de cadastro de um novo cadastroMembro
 * @author Fernando de Campos Pinheiro
 */
public class ValidadorFormularioMembro {


    private BindingResult resultado;
    private FormularioMembro formulario;
    private ValidaEmail email = new ValidaEmail();
    private ValidaNome nome = new ValidaNome();
    private ValidaSenha senha = new ValidaSenha();

    public ValidadorFormularioMembro(FormularioMembro formulario, BindingResult resultado){
        this.resultado = resultado;
        this.formulario = formulario;
    }

    public void validaCampos() throws DadosInvalidosException{
        email.valida(formulario.getEmail(),resultado);
        nome.valida(formulario.getNome(),resultado);
        senha.valida(formulario.getSenha(),resultado);
    }


}
