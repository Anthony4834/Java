package com.anthony4834.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anthony4834.dojosninjas.models.Ninja;
import com.anthony4834.dojosninjas.repositories.NinjaRepo;

@Service
public class NinjaServ {
	private NinjaRepo ninjaR;
	
	public NinjaServ(NinjaRepo r) {
		this.ninjaR = r;
	}
	
	public List<Ninja> findAll() {
		return ninjaR.findAll();
	}
	public Ninja findOne(Long id) {
		Optional<Ninja> n = ninjaR.findById(id);
		if(n.isPresent()) {
			return n.get();
		}
		return null;
	}
	public Ninja createNinja(Ninja n) {
		return ninjaR.save(n);
	}
	public void delteNinja(Long id) {
		ninjaR.deleteById(id);
	}
}
