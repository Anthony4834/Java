package com.anthony4834.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anthony4834.dojosninjas.models.Dojo;
import com.anthony4834.dojosninjas.repositories.DojoRepo;

@Service
public class DojoServ {
	private DojoRepo dojoR;
	
	public DojoServ(DojoRepo r) {
		this.dojoR = r;
	}
	
	public List<Dojo> findAll() {
		return dojoR.findAll();
	}
	public Dojo findOne(Long id) {
		Optional<Dojo> d = dojoR.findById(id);
		if(d.isPresent()) {
			return d.get();
		}
		return null;
	}
	public Dojo createDojo(Dojo d) {
		return dojoR.save(d);
	}
}
