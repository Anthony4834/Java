package com.anthony4834.driverslicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anthony4834.driverslicense.models.Person;
import com.anthony4834.driverslicense.repositories.PersonRepo;

@Service
public class PersonServ {
	private final PersonRepo personR;
	
	public PersonServ(PersonRepo r) {
		this.personR = r;
	}
	
	public List<Person> findAll() {
		return personR.findAll();
	}
	public Person createPerson(Person p) {
		return personR.save(p);
	}
	public Person findPerson(Long id) {
		Optional<Person> p = personR.findById(id);
		if(p.isPresent()) {
			return p.get();
		}
		return null;
	}
}
