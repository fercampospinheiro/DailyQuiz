package br.com.sidlar.dailyquiz.presentation;

import br.com.sidlar.dailyquiz.domain.CadastroMembroService;
import br.com.sidlar.dailyquiz.domain.FormularioCadastroMembro;
import br.com.sidlar.dailyquiz.domain.Membro;
import br.com.sidlar.dailyquiz.domain.MembroRepository;
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

	@RequestMapping( method = RequestMethod.GET)
	public String carregaCadastroMembro(Membro membro,Model model){
		model.addAttribute(membro);
		return "/CadastroDeMembro/cadastroDeMembro";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String cadastraMembro(FormularioCadastroMembro formulario,Model model,HttpServletRequest request){

		Membro novoMembro = cadastroMembroService.geraMembroComInformacaoDoformulario(formulario);
        System.out.println(novoMembro.getNome());
        Membro  membroNoBanco = membroRepository.buscaMembroPorCredencial(novoMembro.getUserName(), novoMembro.getSenha());
        System.out.println(membroNoBanco.getNome());
		if(membroNoBanco.getUserName().equals(novoMembro.getUserName())){
			model.addAttribute("usuarioExistente","Usuario já existente!");
			return "/CadastroDeMembro/cadastroDeMembro";
		}
		else{
			membroRepository.insereNovoMembro(novoMembro);
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
