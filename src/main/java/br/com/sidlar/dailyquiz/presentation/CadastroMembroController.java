package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
/**
 * @author  Fernando de Campos Pinheiro
 */

@Controller
@RequestMapping("/CadastraMembro")
public class CadastroMembroController {

	@Autowired
	private MembroRepository membroRepository;
	@Autowired
	private CadastroMembroService cadastroMembroService;
    @Autowired
    private MembroFactory membroFactory;

	@RequestMapping( method = RequestMethod.GET)
	public String carregaCadastroMembro(Membro membro,Model model){
		model.addAttribute(membro);
		return "/CadastroDeMembro/cadastroDeMembro";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String cadastraMembro(FormularioCadastroMembro formulario,Model model,HttpServletRequest request){

		Membro novoMembro = membroFactory.geraMembroComInformacaoDoformulario(formulario);
        System.out.println(novoMembro.getNome());
        Membro  membroDoBanco = membroRepository.buscaMembroPorCredencial(novoMembro.getUserName(), novoMembro.getSenha());
		if(membroDoBanco != null){
			model.addAttribute("usuarioExistente","Usuario já existente!");
			return "/CadastroDeMembro/cadastroDeMembro";
		}
		else{
			cadastroMembroService.cadastraNovoMembro(novoMembro);
			request.getSession().setAttribute("usuarioAutenticado",novoMembro);
			return  "/Home/index";
		}

	}

	@RequestMapping()
	public String verificaNivelDeSegurancaDaSenha(String senha, Model model){
		//implementação
		model.addAttribute("nivelSeguranca",cadastroMembroService.obtemNivelDeSegurancaDaSenhaDoMebro(senha));
		return "";
	}


}
