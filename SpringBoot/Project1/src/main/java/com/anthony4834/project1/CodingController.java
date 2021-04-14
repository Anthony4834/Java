package com.anthony4834.project1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("coding")
public class CodingController {
	@RequestMapping("")
	public String hello() {
		return "Hello Coding Dojo";
	}
	@RequestMapping("/python")
	public String helloPython() {
		return "Python/Django was awesome";
	}
	@RequestMapping("/java")
	public String helloJava() {
		return "Java/Spring is better";
	}
}
