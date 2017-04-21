package net.lermex.inaction.signup;

import net.lermex.inaction.model.entity.User;
import net.lermex.inaction.helper.UsersContainer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class SignUpController {

    // working
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    @ResponseBody // отключает отработку итоговой строки как редирект на страницу. Т.е. передает просто строку.
    public ModelAndView redirectToSignUp() {
        ModelAndView mav = new ModelAndView("signup/signup");
        mav.addObject("signupForm", new User());
        return mav;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String doSignUp(@ModelAttribute("signupForm") User user, BindingResult result,
                           Model model,
                           final RedirectAttributes redirectAttributes,
                           HttpSession session) {

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("message", "fail");

            return "signup";
        } else {
            model.addAttribute("signupForm",user);
            UsersContainer.getUsersContainer().addUser(user.getEmail(), user.getPassword());
            session.setAttribute("username", user.getEmail());
            return "redirect:/homesignin";
        }

    }
}