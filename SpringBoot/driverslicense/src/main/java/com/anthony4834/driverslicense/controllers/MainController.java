package com.anthony4834.driverslicense.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anthony4834.driverslicense.models.License;
import com.anthony4834.driverslicense.models.Person;
import com.anthony4834.driverslicense.services.LicenseServ;
import com.anthony4834.driverslicense.services.PersonServ;

@Controller
public class MainController {
	private final PersonServ personS;
	private final LicenseServ licenseS;
	
	public MainController(PersonServ pS, LicenseServ lS) {
		this.personS = pS;
		this.licenseS = lS;
	}
	@RequestMapping("/")
	public String index(Model model, @ModelAttribute("PERSON") Person person) {
		return "/people/newPerson.jsp";
	}
	@RequestMapping("/person/{id}")
	public String display(@PathVariable("id") Long id, Model m) {
		License l = licenseS.findByPerson_id(id);
		
		m.addAttribute("person", personS.findPerson(id));
		m.addAttribute("license", l);
		return "people/displayPerson.jsp";
	}
	@RequestMapping(value = "/people/new", method = RequestMethod.POST)
	 public String create(Model model, @Valid @ModelAttribute("PERSON") Person person, @RequestParam("firstName") String first, @RequestParam("lastName") String last, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "redirect:/";
        } else {
            personS.createPerson(person);
            return "redirect:/";
        }
    }
	@RequestMapping("/license/create")
	public String newLicense(Model model, @ModelAttribute("LICENSE") License lic) {
		List<Person> people = personS.findAll();
		model.addAttribute("people", people);
		return "/people/newLicense.jsp";
	}
	@RequestMapping(value = "/license/new", method = RequestMethod.POST)
	public String createLicense(Model model, RedirectAttributes redirectAttributes, @RequestParam("person") Person p, @RequestParam("state") String state, @RequestParam("expiry") String exp) throws ParseException {
		Date date = null;
		if(exp.isEmpty()) {
			return "redirect:/license/create";
		}
		License lic = new License(date, state, p); 
		lic.setExpiry(lic.getDateFromString(exp));
		
		licenseS.createLicense(lic);
		
		return("redirect:/license/create");
	}
}
