package net.lermex.inaction.logout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping(value = "/logout")
    public String doLogout(HttpSession session){
        session.invalidate();
        return "redirect:/homenotsign";
    }

}