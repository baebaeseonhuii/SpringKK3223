package com.kk3223.app.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentDAO sDAO;
	
	public List<StudentDTO> getStudents() {
		try {
			return sDAO.getStudents();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void makeStudent(StudentDTO sDTO) {
		try {
			sDAO.makeStudent(sDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public StudentDTO getDetail(StudentDTO sDTO) {
		try {
			sDTO = this.sDAO.getDetail(sDTO);
			return sDTO;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void delete(StudentDTO sDTO) {
		try {
			sDAO.delete(sDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(StudentDTO sDTO) {
		try {
			sDAO.update(sDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
