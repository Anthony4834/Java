package com.anthony4834.project1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingController {
	@RequestMapping("/")
	public String hello(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "lastName", required = false) String last) {
		String fullName = name != null ? name : "";
		if(last != null) {
			fullName += " " + last;
		}
		return fullName == null ? "Hello human" : "Hello " + fullName;
	}
}
