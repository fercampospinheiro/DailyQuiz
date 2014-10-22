package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.*;
import br.com.sidlar.dailyquiz.domain.Excecoes.EmailJaCadastradoException;
import br.com.sidlar.dailyquiz.infrastructure.AutenticacaoService;
import br.com.sidlar.dailyquiz.presentation.Excecoes.DadosInvalidosException;
import br.com.sidlar.dailyquiz.presentation.Validacoes.ValidadorFormulario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author  Fernando de Campos Pinheiro
 * Responsavel por todas as solicitações que envolvem o cadastro de um membro
 */

@Controller
@RequestMapping("/CadastraMembro")
public class CadastroMembroController {

    @Autowired private MembroFactory membroFactory;
	@Autowired private AutenticacaoService autenticacaoService;
	@Autowired MembroRepository repository;
    /**
	 * Carrega a página o formulario para cadastro de um novo membro
	 */
	@RequestMapping( method = RequestMethod.GET)
	public String carregaCadastroMembro(Model model){
		FormularioMembro formulario = new FormularioMembro();
        model.addAttribute("formulario",formulario);
		return "/CadastroDeMembro/cadastroDeMembro";
	}

	/**
	 * Cadastra um novo membro seguindo os seguintes passos :
     * - Recebe os dados do formulario
     * - Valida os dados do formulario
     * - Cadastra o novo membro no repositorios de membros
     * - E autentica o membro e redireciona logado para a home.
	 * @param formulario : Recebe um objeto Formulario populado
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String cadastraMembro(
        @ModelAttribute("formulario")FormularioMembro formulario,
        Model model,
        BindingResult resultado
        ){

        try {
            ValidadorFormulario validador = new ValidadorFormulario(formulario,resultado);
            validador.validaCampos();
            Membro membro = membroFactory.fabricaPorformulario(formulario);
            repository.adicionaNovoMembro(membro);
			autenticacaoService.autenticaMembro(membro);
            return "redirect:/";
		}
		catch (EmailJaCadastradoException e) {
            resultado.rejectValue("email","resultado",e.getMessage());
            return "/CadastroDeMembro/cadastroDeMembro";
        }
        catch (DadosInvalidosException e){
            return "/CadastroDeMembro/cadastroDeMembro";
        }

	}


}
