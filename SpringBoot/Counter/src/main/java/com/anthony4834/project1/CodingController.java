package com.anthony4834.project1;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CodingController {
	@RequestMapping("/")
	public String home(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if(count == null) {
			session.setAttribute("count", 1);
		} else {
			session.setAttribute("count", count += 1);
		}
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String date(HttpSession session, Model model) {
		Integer count = (Integer) session.getAttribute("count");
		model.addAttribute("count", count);
		return "count.jsp";
	}
}
