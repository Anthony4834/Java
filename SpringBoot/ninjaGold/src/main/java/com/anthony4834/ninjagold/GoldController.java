package com.anthony4834.ninjagold;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class GoldController {
	public class Card {
		private String name;
		private Integer min;
		private Integer max;
		private String minColor;
		
		public Card(String name, Integer min, Integer max ) {
			this.name = name;
			this.min = min;
			this.max = max;
			this.minColor = this.min > 0 ? "green" : "red";
		}
		
		private int getRandomNum(int min, int max) {
			  return (int) (Math.random() * (max - min) + min);
		}
		
		public Integer activate() {
			Integer score = getRandomNum(this.min, this.max);
			System.out.println(score);
			return score;
		}
		public String getName() {
			return this.name;
		}
		public Integer getMin() {
			return this.min;
		}
		public Integer getMax() {
			return this.max;
		}
		public String getMinColor() {
			return this.minColor;
		}
	}
	public static final String TIMESTAMP_PATTERN = "MM/dd/yy hh:mm:ss a"; 
    public static final DateTimeFormatter LDT_FOMATTER = DateTimeFormatter.ofPattern(TIMESTAMP_PATTERN);
    private static String formatLocalDateTime(LocalDateTime ldt)
    {
        return LDT_FOMATTER.format(ldt);
    }
	@RequestMapping("/")
	public String home(HttpSession session, Model model) {
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<String> logItems = new ArrayList<String>();
		
		cards.add(new Card("Farm", 10, 21));
		cards.add(new Card("Cave", 5, 11));
		cards.add(new Card("House", 2, 6));
		cards.add(new Card("Casino", -50, 51));
		
		model.addAttribute("cards", cards);
		
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("logItems", logItems);
		}
		return "index.jsp";
	}
	@RequestMapping(value= "/submit", method=RequestMethod.POST)
	public String submit(HttpSession session, @RequestParam("score") Integer score, @RequestParam("name") String name) {
		String dateTimeString = formatLocalDateTime(LocalDateTime.now()); 
		session.setAttribute("gold", (Integer) session.getAttribute("gold") + score);
		@SuppressWarnings("unchecked")
		ArrayList<String> arr = (ArrayList<String>) session.getAttribute("logItems");
		if(score > 0) {
			arr.add(String.format("You gained %s gold from the %s! [%s]", score, name, dateTimeString));
		} else {
			arr.add(String.format("You lost %s gold from the %s! [%s]", Math.abs(score), name, dateTimeString));
		}
		session.setAttribute("logItems", arr);
		return "redirect:/";
	}
}