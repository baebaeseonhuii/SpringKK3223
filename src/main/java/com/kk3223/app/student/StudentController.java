package com.kk3223.app.student;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/student/list")
	public String getStudents(HttpServletRequest request) {
		List<StudentDTO> sDTOs = this.studentService.getStudents();
		if (sDTOs != null) {
			request.setAttribute("list", sDTOs);
			return "student/list";
		} else {
			request.setAttribute("messages", "정보가 없습니다");
			return "commons/messages";
		}
	}
	
	@RequestMapping(value="/student/add", method=RequestMethod.GET)
	public String add() {
		return "student/add";
	}
	
	@RequestMapping(value="/student/add", method=RequestMethod.POST)
	public String add2(HttpServletRequest request) {
		StudentDTO sDTO = new StudentDTO();
		String name = request.getParameter("name");
		Calendar ca = Calendar.getInstance();
		long num = ca.getTimeInMillis();
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));

		sDTO.setName(name);
		sDTO.setNum(num);
		sDTO.setKor(kor);
		sDTO.setEng(eng);
		sDTO.setMath(math);

		studentService.makeStudent(sDTO);

		return "redirect:/student/list";
	}
	
	@RequestMapping(value="/student/delete", method=RequestMethod.GET)
	public String delete() {
		return "redirect:/student/list";
	}
	
	@RequestMapping(value="/student/delete", method=RequestMethod.POST)
	public String delete2(HttpServletRequest request) {
		StudentDTO sDTO = new StudentDTO();
		sDTO.setNum(Long.parseLong(request.getParameter("num")));
		studentService.delete(sDTO);
		return "redirect:/student/list";
	}
	
	@RequestMapping("/student/detail")
	public String getDetail(HttpServletRequest request) {
		StudentDTO sDTO = new StudentDTO();
		sDTO.setNum(Long.parseLong(request.getParameter("num")));
		sDTO = studentService.getDetail(sDTO);
		if (sDTO != null) {
			request.setAttribute("sDTO", sDTO);
			return "student/detail";
		} else {
			request.setAttribute("messages", "정보가 없습니다");
			return "commons/messages";
		}
	}
	
	@RequestMapping(value="/student/update", method=RequestMethod.GET)
	public String update(HttpServletRequest request) {
		StudentDTO sDTO = new StudentDTO();
		sDTO.setNum(Long.parseLong(request.getParameter("num")));
		sDTO = studentService.getDetail(sDTO);
		request.setAttribute("sDTO", sDTO);
		return "student/update";
	}
	
	@RequestMapping(value="/student/update", method=RequestMethod.POST)
	public String update2(HttpServletRequest request) {
		StudentDTO sDTO = new StudentDTO();
		sDTO.setNum(Long.parseLong(request.getParameter("num")));
		sDTO.setName(request.getParameter("name"));
		sDTO.setKor(Integer.parseInt(request.getParameter("kor")));
		sDTO.setEng(Integer.parseInt(request.getParameter("eng")));
		sDTO.setMath(Integer.parseInt(request.getParameter("math")));
		studentService.update(sDTO);
		return "redirect:/student/list";
	}


	
}
