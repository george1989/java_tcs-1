package com.onuar.ejemplo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
	
	@GetMapping("/message/{name}")
	public String getMessage(@PathVariable("name") String name)
	{
		
		return "Hello Work "+name;
	}

}
