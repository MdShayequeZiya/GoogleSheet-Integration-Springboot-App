package com.ff.sheetsintegration.services;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ff.sheetsintegration.entity.Student;
import com.ff.sheetsintegration.repository.StudentRepository;
import com.ff.sheetsintegration.util.RequestMapper;
import com.ff.sheetsintegration.util.SheetsUtility;

@Service
public class StudentService {
	
	@Autowired
	SheetsUtility api;
	
	@Autowired
	StudentRepository studentRepository;

	public ResponseEntity<?> readDataFromGoogleSheets() throws IOException, GeneralSecurityException {
		// TODO Auto-generated method stub
		;
		
		List<List<Object>> dataFromGoodSheets = api.getDataFromGoodSheets();
		
		if(dataFromGoodSheets ==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<Student> students = new ArrayList<>();
		for(List<Object> studentObject : dataFromGoodSheets) {
			
			students.add(RequestMapper.objectsToStudents(studentObject));
			
		}
		
		
		List<Student> savedStudents = studentRepository.saveAll(students);
		
		return new ResponseEntity<List<Student>>(savedStudents, HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<?> getAllStudents(){
		
		List<Student> savedStudents = studentRepository.findAll();
		
		return new ResponseEntity<List<Student>>(savedStudents, HttpStatus.CREATED);
		
	}

}
