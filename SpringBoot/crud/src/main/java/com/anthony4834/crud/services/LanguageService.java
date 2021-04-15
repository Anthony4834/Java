package com.anthony4834.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anthony4834.crud.models.Language;
import com.anthony4834.crud.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	public List<Language> allLangs() {
		return langRepo.findAll();
	}
	
	public Language createLanguage(Language l) {
		return langRepo.save(l);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> l = langRepo.findById(id);
		if(l.isPresent()) {
			return l.get();
		} else {
			return null;
		}
	}
	public Language updateLanguage(Long id, Language lang) {
		Optional<Language> l = langRepo.findById(id);
		if(l.isPresent()) {
			lang.setId(id);
			return langRepo.save(lang);
		} else {
			return null;
		}
	}
	public Boolean deleteLanguage(Long id) {
		Optional<Language> toDelete = langRepo.findById(id);
		if(toDelete.isPresent()) {
			langRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
