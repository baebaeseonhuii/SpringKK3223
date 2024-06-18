package com.kk3223.app.student;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	public String getList() {
		System.out.println("StudentService getList() 호출");
		return "student/list";
	}
	
}
