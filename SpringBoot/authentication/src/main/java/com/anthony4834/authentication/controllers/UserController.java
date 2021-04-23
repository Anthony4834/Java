package com.anthony4834.authentication.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anthony4834.authentication.models.User;
import com.anthony4834.authentication.services.UserServ;

@Controller
public class UserController {
	private final UserServ serv;
	
	public UserController(UserServ s) {
		this.serv = s;
	}
	@GetMapping("/register")
	public String register(Model m, @ModelAttribute("user") User user, HttpSession session, RedirectAttributes redirect) {
		if(session.getAttribute("loggedID") != null) {
			redirect.addFlashAttribute("error", "You are already logged in");
			return "redirect:/";
		}
		return "register.jsp";
	}
	@PostMapping("/register")
	public String regUser(Model m, @ModelAttribute("user") User user, @RequestParam("email") String email, BindingResult result, RedirectAttributes redirect, HttpSession session) {
		User u = serv.findByEmail(email);
		if(u != null) {
			redirect.addFlashAttribute("error", "Email already in use");
			return "redirect:/register";
		}
		if(!user.getPassword().equals(user.getPasswordConfirmation())) {
			System.out.println(result.getAllErrors());
			redirect.addFlashAttribute("error", "Passwords do not match");
			return "redirect:/register";
		}
		if(user.getPassword().length() < 8) {
			redirect.addFlashAttribute("error", "Password must be 8 or more characters");
			return "redirect:/register";
		}
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "redirect:/register";
			}
		serv.regUser(user);
		session.setAttribute("loggedID", user.getId());
		return "redirect:/";
		}
	@GetMapping("/login")
	public String loginPage(Model m, HttpSession session, RedirectAttributes redirect) {
		if(session.getAttribute("loggedID") != null) {
			redirect.addFlashAttribute("error", "You are already logged in");
			return "redirect:/";
		}
		return "login.jsp";
	}
	@PostMapping("/login")
	public String logUser(Model m, RedirectAttributes re, @RequestParam("email") String email, @RequestParam("password") String pass, @RequestParam("remember") Boolean remember, HttpSession session) {
		User user = serv.findByEmail(email);
		if(user == null) {
			re.addFlashAttribute("error", "Email or password is invalid");
			return "redirect:/login";
		}
		if(serv.authUser(email, pass)) {
			session.setAttribute("loggedID", user.getId());
		} else {
			re.addFlashAttribute("error", "Email or password is invalid");
			return "redirect:/login";
		}
		return "redirect:/";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	//Extra random stuff
	@PutMapping("/user/{id}")
	public String initReset(@PathVariable("id") Long id, @RequestParam("email") String email) {
		User user = serv.findByEmail(email);
		serv.genResetToken(user);
		return "redirect:/";
	}
	@GetMapping("/user/{id}")
	public String initReset(Model m, @PathVariable("id") Long id) {
		m.addAttribute("userId", id);
		return "forgot.jsp";
	}
	@GetMapping("reset/{email}/{resetToken}")
	public String resetVerif(Model m, @PathVariable("resetToken") String token, @PathVariable("email") String email) {
		if(serv.verifResetToken(token, email)) {
			return "resetPass.jsp";
		}
		return "redirect:/user/1";
	}
}
