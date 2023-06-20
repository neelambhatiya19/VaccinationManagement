package com.demo.project.CitizenService.controller;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	
	@GetMapping("/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<>("Hello", HttpStatus.OK);
		
	}

}
