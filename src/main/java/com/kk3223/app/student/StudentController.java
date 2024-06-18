package com.kk3223.app.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/student/list")
	public String getList() {
		return this.studentService.getList();
	}
	
}
