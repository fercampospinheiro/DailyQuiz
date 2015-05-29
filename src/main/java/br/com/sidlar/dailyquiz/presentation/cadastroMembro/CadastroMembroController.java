package br.com.sidlar.dailyquiz.presentation.cadastroMembro;

import br.com.sidlar.dailyquiz.domain.membro.EmailCadastradoException;
import br.com.sidlar.dailyquiz.domain.membro.Membro;
import br.com.sidlar.dailyquiz.domain.membro.MembroFactory;
import br.com.sidlar.dailyquiz.domain.membro.MembroRepository;
import br.com.sidlar.dailyquiz.infrastructure.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author  Fernando de Campos Pinheiro
 * Responsavel por todas as solicitações que envolvem o cadastro de um cadastroMembro
 */

@Controller
@RequestMapping("/CadastraMembro")
public class CadastroMembroController {

    @Autowired private MembroFactory membroFactory;
	@Autowired private AutenticacaoService autenticacaoService;
	@Autowired
    MembroRepository repository;
    /**
	 * Carrega a página o formulario para cadastro de um novo cadastroMembro
	 */
	@RequestMapping( method = RequestMethod.GET)
	public String carregaCadastroMembro(Model model){
		FormularioMembro formulario = new FormularioMembro();
        model.addAttribute("formulario",formulario);
		return "/CadastroMembro/cadastroMembro";
	}

	/**
	 * Cadastra um novo cadastroMembro seguindo os seguintes passos :
     * - Recebe os dados do formulario
     * - Valida os dados do formulario
     * - Cadastra o novo cadastroMembro no repositorios de membros
     * - E autentica o cadastroMembro e redireciona logado para a home.
	 * @param formulario : Recebe um objeto Formulario populado
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String cadastraMembro(
        @ModelAttribute("formulario")FormularioMembro formulario,
        Model model,
        BindingResult resultado
        ){

        try {
            ValidadorFormularioMembro validador = new ValidadorFormularioMembro(formulario,resultado);
            validador.validaCampos();
            Membro membro = membroFactory.comDadosFormulario(formulario);
            repository.adicionaNovoMembro(membro);
			autenticacaoService.autenticaMembro(membro);
            return "redirect:/";
		}
		catch (EmailCadastradoException e) {
            resultado.rejectValue("email","resultado",e.getMessage());
            return "/CadastroMembro/cadastroMembro";
        }
        catch (DadosInvalidosException e){
            return "/CadastroMembro/cadastroMembro";
        }

	}


}
