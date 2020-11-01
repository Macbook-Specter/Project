package com.yibin.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.yibin.dao.PupilRepository;
import com.yibin.dao.TeacherRepostory;
import com.yibin.entiy.Pupil;
import com.yibin.entiy.Teacher;

@SpringBootTest
@ComponentScan(value = "com.yibin")
class Demo1ApplicationTests {
	@Autowired
	private TeacherRepostory tdao;
	@Autowired
	private PupilRepository pdao;
	@Test
	void contextLoads() {
		Pupil p1=new Pupil(1,"黄锐","nv");
		Pupil p2=new Pupil(2,"蔡总","男");
		Pupil p3=new Pupil(3,"市场价","女");
		Pupil p4=new Pupil(4,"小木","男");
		
		Teacher teacher1=new Teacher();
		teacher1.setName("李老师");
		teacher1.getPupils().add(p1);
		teacher1.getPupils().add(p3);
		teacher1.getPupils().add(p4);
		
		Teacher teacher2=new Teacher();
		teacher2.setName("赵老师");
		teacher2.getPupils().add(p1);
		teacher2.getPupils().add(p2);
		teacher2.getPupils().add(p3);

		Teacher teacher3=new Teacher();
		teacher3.setName("张老师");
		teacher3.getPupils().add(p2);
		teacher3.getPupils().add(p3);
		teacher3.getPupils().add(p4);
		
		pdao.save(p1);
		pdao.save(p2);
		pdao.save(p3);
		pdao.save(p4);
		
		tdao.save(teacher1);
		tdao.save(teacher2);
		tdao.save(teacher3);
		
	System.out.println("数据库初始化。。。。");
	}

}
