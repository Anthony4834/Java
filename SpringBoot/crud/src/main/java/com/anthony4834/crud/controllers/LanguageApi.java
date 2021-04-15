package com.anthony4834.crud.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anthony4834.crud.models.Language;
import com.anthony4834.crud.services.LanguageService;

@RestController
public class LanguageApi {
	private final LanguageService langServ;
	
	public LanguageApi(LanguageService langServ) {
		this.langServ = langServ;
	}
	
	@RequestMapping("/api/languages")
	public List<Language> index() {
		return langServ.allLangs();
	}
	@RequestMapping(value="/api/languages", method=RequestMethod.POST)
	public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
		Language lang = new Language(name, creator, version);
		return langServ.createLanguage(lang);
	}
	@RequestMapping("/api/language/{id}")
	public Language show(@PathVariable("id") Long id) {
		Language lang = langServ.findLanguage(id);
		return lang;
	}
	@RequestMapping(value="/api/language/{id}/edit", method=RequestMethod.PUT)
    public Language update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
        Language lang = new Language(name, creator, version);
        langServ.updateLanguage(id, lang);
        return langServ.findLanguage(id);
    }
	@RequestMapping(value="/api/language/{id}/delete", method=RequestMethod.DELETE)
	public Boolean destroy(@PathVariable("id") Long id) {
		return langServ.deleteLanguage(id);
	}
}
