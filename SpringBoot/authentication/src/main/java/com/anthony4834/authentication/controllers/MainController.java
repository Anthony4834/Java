package com.anthony4834.authentication.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anthony4834.authentication.services.UserServ;

@Controller
public class MainController {
	private final UserServ serv;
	
	public MainController(UserServ s) {
		this.serv = s;
	}
	
	@GetMapping("/")
	public String index(HttpSession session, Model m, RedirectAttributes re) {
		Long id = (Long) session.getAttribute("loggedID");
		if(id == null) {
			re.addFlashAttribute("error", "Please login");
			return "redirect:/login";
		} else {
			m.addAttribute("user", serv.findByUserId(id));
			return "index.jsp";
		}
	}
}
