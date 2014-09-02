package br.com.sidlar.dailyquiz.presentation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(method = RequestMethod.GET)
    public String goHome() {
        return "redirect:/Login";
    }


}
