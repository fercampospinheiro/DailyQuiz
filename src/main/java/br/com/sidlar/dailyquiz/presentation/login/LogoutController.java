package br.com.sidlar.dailyquiz.presentation.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author  Fernando de Campos Pinheiro
 */
@Controller
@RequestMapping("/Logout")
public class LogoutController {

    @RequestMapping(method = RequestMethod.POST)
    public String fazLogout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}
