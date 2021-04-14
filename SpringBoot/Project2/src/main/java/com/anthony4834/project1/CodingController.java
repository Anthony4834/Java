package com.anthony4834.project1;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CodingController {
	@RequestMapping("/")
	public String home(Model model) {
		Date date = new java.util.Date();
		model.addAttribute("date", date);
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new java.util.Date();
		model.addAttribute("date", date);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new java.util.Date();
		model.addAttribute("date", date);
		return "time.jsp";
	}
}
