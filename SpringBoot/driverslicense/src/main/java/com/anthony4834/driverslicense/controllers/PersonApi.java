package com.anthony4834.driverslicense.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anthony4834.driverslicense.models.Person;
import com.anthony4834.driverslicense.services.PersonServ;

@RestController
public class PersonApi {
	private final PersonServ personS;
	
	public PersonApi(PersonServ s){
		this.personS = s;
	}
	
	@RequestMapping("/api/people")
	public List<Person> index() {
		return personS.findAll();
	}
	@RequestMapping(value = "/api/people/new", method = RequestMethod.POST)
	public void addNew(@RequestParam("firstName") String first, @RequestParam("lastName") String last) {
		Person p = new Person(first, last);
		personS.createPerson(p);
	}
	@RequestMapping("/api/person/{id}")
	public Person findPerson(@PathVariable("id") Long id) {
		return personS.findPerson(id);
	}
}
