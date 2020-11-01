package com.yibin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yibin.Services.OneToManyServices;
import com.yibin.dao.PupilRepository;
import com.yibin.dao.TeacherRepostory;
import com.yibin.entiy.Pupil;
import com.yibin.entiy.Student;
import com.yibin.entiy.Teacher;

@Controller
public class LinkController {
	@Autowired
	private TeacherRepostory tdao;
	@Autowired
	private PupilRepository pdao;
	@Autowired
	@Qualifier("oneservice")
	private OneToManyServices oneservices;
	@RequestMapping("/index")
	public String OneToMany(Model m) {
		Student student=oneservices.queryStudentById(1);
		System.out.println(student);
		m.addAttribute("student",student);
		return "index";
	}
	
	@RequestMapping("/manyresult")
	public String ManyToMany(Model m) {
	
		
		List<Teacher> teachers=tdao.findAll();
		m.addAttribute("teachers", teachers);
		
		for (Teacher teacher:teachers) {
			System.out.println(teacher.getId()+"  "+teacher.getName());
			List<Pupil> ps=teacher.getPupils();
			System.out.println(ps);
		}
		return "manyresult";
	}
}
