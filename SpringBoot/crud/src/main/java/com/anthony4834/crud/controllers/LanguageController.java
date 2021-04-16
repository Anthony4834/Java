package com.anthony4834.crud.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anthony4834.crud.models.Language;
import com.anthony4834.crud.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService langServ;
	
	public LanguageController(LanguageService ls) {
		this.langServ = ls;
	}
	
	@RequestMapping("/languages")
	public String index(Model model) {
		List<Language> arr = langServ.allLangs();
		model.addAttribute("langs", arr);
		return "/langs/index.jsp";
	}
	@RequestMapping("/language/{id}")
	public String display(@PathVariable("id") Long id, Model model) {
		Language lang = langServ.findLanguage(id);
		model.addAttribute("lang", lang);
		return "/langs/display.jsp";
	}
	@RequestMapping("/languages/new")
	public String addNewLang(@ModelAttribute("language") Language language) {
		return "/langs/new.jsp";
	}
	@RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/languages/new";
        } else {
            langServ.createLanguage(language);
            return "redirect:/languages";
        }
    }
}
