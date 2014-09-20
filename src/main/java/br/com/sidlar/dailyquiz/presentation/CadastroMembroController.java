package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.*;
import br.com.sidlar.dailyquiz.infrastructure.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	 * @param membro
	 * @param model
	 * @return String
	 */
	@RequestMapping( method = RequestMethod.GET)
	public String carregaCadastroMembro(Membro membro,Model model){
		model.addAttribute(membro);
		return "/CadastroDeMembro/cadastroDeMembro";
	}

	/**
	 * Delega a {@link br.com.sidlar.dailyquiz.domain.MembroFactory}  a criação de um membro com dados do {@link br.com.sidlar.dailyquiz.domain.FormularioCadastroMembro},
	 * verifica a existencia deste membro no {@link br.com.sidlar.dailyquiz.domain.MembroRepository} e faz a membroAutenticado do mesmo.
	 * @param formulario
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String cadastraMembro(FormularioCadastroMembro formulario,Model model){

        try {
            ValidadorUtils.validaFormulario(formulario);
            Membro membro = membroFactory.geraMembroComInformacaoDoformulario(formulario);
            cadastroMembroService.cadastraNovoMembro(membro);
			autenticacaoService.autenticaMembro(membro);
			return "/CadastroDeMembro/cadastroComSucesso";
		}
		catch (EmailOuSenhaJaExistenteException e){
			model.addAttribute("emailOuSenhaInvalida",e.getMessage());
            return "/CadastroDeMembro/cadastroDeMembro";
		}
        catch (DadosInvalidosException e){
            model.addAttribute("dadosInvalidos",e.getMessage());
            return "/CadastroDeMembro/cadastroDeMembro";
        }
	}


}
