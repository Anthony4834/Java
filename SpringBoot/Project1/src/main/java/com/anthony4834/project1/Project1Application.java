package com.anthony4834.project1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		return "Hello client";
	}
	@RequestMapping("/random")
	public String helloRandom() {
		return "Spring boot is kinda cool";
	}

}
