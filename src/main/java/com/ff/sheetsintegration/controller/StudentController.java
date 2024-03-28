package com.ff.sheetsintegration.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ff.sheetsintegration.services.StudentService;

@RestController
public class StudentController {
	
	
	@Autowired
	StudentService studentService;
	
	
	@GetMapping("/")
	public String testEndPoint() {
		return "success";
	}
	
	
	@PostMapping("/saveDataFromSheets")
	public ResponseEntity<?> readDataFromGoogleSheets() throws IOException, GeneralSecurityException {
		return studentService.readDataFromGoogleSheets();
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllStudents()  {
		return studentService.getAllStudents();
	}

}
