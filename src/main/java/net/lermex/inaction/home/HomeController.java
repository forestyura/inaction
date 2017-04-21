package net.lermex.inaction.home;

import net.lermex.inaction.model.entity.Statistics;
import net.lermex.inaction.model.entity.User;
import net.lermex.inaction.helper.UsersContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private Statistics statistic;

	@RequestMapping(value = {"/",  "/homenotsign"})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("home/homeNotSignedIn");
		statistic.generateStatistics();
		modelAndView.addObject("statistics", statistic);
        return modelAndView;
	}

	@RequestMapping(value = "/updatestatistics", method = RequestMethod.GET)
	@ResponseBody
	public void updatestatistics(HttpServletResponse resp) throws IOException {
		statistic.generateStatistics();
		List<Integer> statisticsList = statistic.getStatisticsList();
		PrintWriter writer = resp.getWriter();
		writer.print(statisticsList.toString());
	}

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ModelAndView doLogin(@RequestParam String username,
                                @RequestParam String password,
                                HttpSession session) {

        //List <User> users = container.getUserList();
        List <User> users = UsersContainer.getUsersContainer().getUserList();

        if (UsersContainer.getUsersContainer().isCredentialsValid(username, password, users)) {
            //HttpSession session = req.getSession();
            session.setAttribute("username", username);
            return new ModelAndView("redirect:/homesignin");
        } else {
            ModelAndView mav = new ModelAndView("signin/signin");
            mav.addObject("isvalid", false);
            return mav;
        }
    }

    @RequestMapping(value = "/homesignin", method = RequestMethod.GET)
    public ModelAndView doSignIn() {

        ModelAndView mav = new ModelAndView("home/homeSignedIn");
        statistic.generateStatistics();
        mav.addObject("statistics", statistic);
        return mav;
    }
}
