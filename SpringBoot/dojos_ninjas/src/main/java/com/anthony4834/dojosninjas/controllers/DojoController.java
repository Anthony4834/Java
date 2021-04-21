package com.anthony4834.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anthony4834.dojosninjas.models.Dojo;
import com.anthony4834.dojosninjas.models.Ninja;
import com.anthony4834.dojosninjas.services.DojoServ;
import com.anthony4834.dojosninjas.services.NinjaServ;

@Controller
public class DojoController {
	private final DojoServ dojoS;
	private final NinjaServ ninjaS;
	
	public DojoController(DojoServ dS, NinjaServ nS) {
		this.dojoS = dS;
		this.ninjaS = nS;
	}
	
	@RequestMapping("/")
	public String index(Model m, @ModelAttribute Dojo dojo) {
		return "/addDojo.jsp";
	}
	@RequestMapping(value="/dojos/new", method=RequestMethod.POST)
	public String createDojo(Model m, @Valid @ModelAttribute Dojo dojo, BindingResult result, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "redirect:/";
		} else {
			dojoS.createDojo(dojo);
			return "redirect:/";
		}
	}
	@RequestMapping("/dojo/{id}")
	public String displayDojo(Model m, @PathVariable("id") Long id) {
		m.addAttribute("dojo", dojoS.findOne(id));
		m.addAttribute("ninjas", dojoS.findOne(id).getNinjas());
		return "/displayDojo.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String addNinja(@ModelAttribute Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoS.findAll());
		model.addAttribute("ninjas", ninjaS.findAll());
		return "addNinja.jsp";
	}
	@RequestMapping(value="/ninjas/new", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute Ninja ninja, BindingResult res, Model model) {
		if(res.hasErrors()) {
			System.out.println("I should've taken C#");
			model.addAttribute("dojos", dojoS.findAll());
			model.addAttribute("ninjas", ninjaS.findAll());
			return "addNinja.jsp";
		}else {
			ninjaS.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
}
