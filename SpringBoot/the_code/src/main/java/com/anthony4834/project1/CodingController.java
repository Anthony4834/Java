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
	
	@RequestMapping(value = "/api/submit", method= RequestMethod.POST)
	public String submit(@RequestParam("code") String code, HttpSession session) {
		if(code.equals("bushido")) {
			session.setAttribute("code", true);
			return "redirect:/success";
		} else {
			session.setAttribute("code", false);
			return "redirect:/err";
		}
	}
	
	@RequestMapping("/err")
	public String flashMessages(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "Incorrect code");
		return "redirect:/";
	}
	@RequestMapping("/success")
	public String success(RedirectAttributes redirectAttributes, HttpSession session) {
		Boolean result = (Boolean) session.getAttribute("code");
		if(result.equals(true)) {
			return "success.jsp";
		} else {
			redirectAttributes.addFlashAttribute("error", "Incorrect code");
			return "redirect:/";
		}
	}
}
