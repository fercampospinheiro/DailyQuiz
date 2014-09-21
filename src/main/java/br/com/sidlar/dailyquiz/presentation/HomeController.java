package br.com.sidlar.dailyquiz.presentation;
import br.com.sidlar.dailyquiz.infrastructure.DadosDeAutenticação;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author  Fernando de Campos Pinheiro
 *
 * Delega solicitações da view <b>home</b> aos serviços e repositorios
 * referentes ao domínio home.
 *
 */
@RequestMapping("/")
@Controller
public class HomeController {

    @Autowired private HttpSession session;

    @RequestMapping(method = RequestMethod.GET)
    public String goHome() {

        DadosDeAutenticação dadosDeAutenticação;
        dadosDeAutenticação = (DadosDeAutenticação) session.getAttribute("dadosDaAutenticacao");

        if (dadosDeAutenticação != null) return "Home/index";
        else return "redirect:/Login";
    }

}
