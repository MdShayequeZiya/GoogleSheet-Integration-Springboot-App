package com.ff.sheetsintegration.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ff.sheetsintegration.services.SubjectService;

@RestController
public class SubjectController {
	
	
	@Autowired
	SubjectService service;
	
	@GetMapping("/testing")
	public String saveData() throws IOException, GeneralSecurityException {
		
		service.saveTheDataFromSheets();
		return "success";
	}

}
