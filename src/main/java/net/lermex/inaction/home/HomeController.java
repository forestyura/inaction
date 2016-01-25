package net.lermex.inaction.home;

import net.lermex.inaction.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private TestBean testBean;

	@RequestMapping(value = "/")
	public ModelAndView index() {
		testBean.testMethod();

        final ModelAndView mav = new ModelAndView("home/homeNotSignedIn");
        mav.addObject("customers", "test");
		return mav;
	}

}
