package com.anthony4834.project1;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodingController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	@RequestMapping("/result")
	public String result(HttpSession session) {
		return "result.jsp";
	}
	@RequestMapping(value= "/submit", method= RequestMethod.POST )
	public String submit(@RequestParam("name") String name, @RequestParam("location") String location,
			@RequestParam("language") String language, @RequestParam("comment") String comment, HttpSession session) {
		
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		if(!comment.equals(null)) {
			session.setAttribute("comment", comment);
		}
		
		return "redirect:/result";
	}
}