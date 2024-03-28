package com.ff.sheetsintegration.util;

import java.util.List;

import com.ff.sheetsintegration.entity.Student;

public class RequestMapper {
	
	
	public static Student objectsToStudents (List<Object> studentData) {
		
		return Student.builder().username((String)studentData.get(0))
							.email((String)studentData.get(1)).phone(Long.valueOf((String)studentData.get(2))).password((String)studentData.get(3))
							.build();
		
	}

}
