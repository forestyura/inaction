package net.lermex.inaction.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public ModelAndView index() {
        final ModelAndView mav = new ModelAndView("home/homeNotSignedIn");
        mav.addObject("customers", "test");
		return mav;
	}

}
