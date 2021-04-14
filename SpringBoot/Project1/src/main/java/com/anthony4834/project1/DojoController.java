package com.anthony4834.project1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/{name}")
	public String dojo2(@PathVariable("name") String name) {
		System.out.println(name.getClass()); 	//String
		System.out.println("dojo".getClass()); 	//String
		System.out.println(name);				//dojo
		System.out.println("dojo");				//dojo
		System.out.println(name == "dojo");		// false ???
		if(name == "dojo") {
			// return "the dojo is awesome";
			return "I do not understand";
		} else if(name == "burbank-dojo") {
			// return "Burbank dojo is located in southern CA";
			return "Why this does not work";
		} else {
			//return "SJ dojo is the headquarters";
			return "????";
		}
	}
}
