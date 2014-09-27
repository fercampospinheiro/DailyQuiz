package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.*;
import br.com.sidlar.dailyquiz.infrastructure.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author  Fernando de Campos Pinheiro
 *
 * Delega solicitações da view <b>cadastroDeMembro</b> aos serviços, repositorios e fábricas do dominio do Membro
 * referentes ao processo de cadastro
 *
 */

@Controller
@RequestMapping("/CadastraMembro")
public class CadastroMembroController {

	@Autowired private MembroRepository membroRepository;
	@Autowired private CadastroMembroService cadastroMembroService;
    @Autowired private MembroFactory membroFactory;
	@Autowired private AutenticacaoService autenticacaoService;

	/**
	 * Carrega a pagina de Cadastro de Membro
	 * @param formulario : Envia um objeto formulario para JSP para ser populado pelo Spring
	 */
	@RequestMapping( method = RequestMethod.GET)
	public String carregaCadastroMembro(FormularioCadastroMembro formulario,Model model){
		model.addAttribute("formulario",formulario);
		return "/CadastroDeMembro/cadastroDeMembro";
	}

	/**
	 * Cadastra um novo membro seguindo os seguintes passos :
     * - Recebe os dados do JSP em um objeto do tipo Formulario
     * - Valida os dados deste objeto poe uma classe utilitária
     * - Se não estiverem consistentes devolve exceções informando os erros de validação.
     * - Se estiverem consistentes gera um membro atraves de uma fábrica de membros
     * - Cadastra o novo membro no repositorios de membros
     * - E autentica os dados de autenticação do membro e redireciona para a home.
	 * @param formulario : Recebe um objeto Formulario populado
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String cadastraMembro(@ModelAttribute("formulario")FormularioCadastroMembro formulario,Model model){

        try {
            ValidadorUtils.validaFormulario(formulario);
            Membro membro = membroFactory.geraMembroComInformacaoDoformulario(formulario);
            cadastroMembroService.cadastraNovoMembro(membro);
			autenticacaoService.autenticaMembro(membro);
            return "redirect:/";
		}
		catch (EmailOuSenhaJaExistenteException e){
            model.addAttribute("dadosInvalidos",e);
            return "/CadastroDeMembro/cadastroDeMembro";
		}
        catch (DadosInvalidosException e){
            model.addAttribute("dadosInvalidos",e);
            return "/CadastroDeMembro/cadastroDeMembro";
        }
	}


}
