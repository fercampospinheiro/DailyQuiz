package br.com.sidlar.dailyquiz.presentation;
import br.com.sidlar.dailyquiz.infrastructure.DadosDeAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author  Fernando de Campos Pinheiro
 *
 * Reponsável pelas chamadas relacionadas a página principal da Aplicação , a Home.
 *
 */
@RequestMapping("/")
@Controller
public class HomeController {

    @Autowired private HttpSession session;

    @RequestMapping(method = RequestMethod.GET)
    public String goHome() {

        DadosDeAutenticacao dadosDeAutenticação;
        dadosDeAutenticação = (DadosDeAutenticacao) session.getAttribute("dadosDeAutenticacao");

        if (dadosDeAutenticação != null) return "/Home/index";
        else return "redirect:/Login";
    }

}
