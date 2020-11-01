package com.yibin.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yibin.dao.StudentMapper;
import com.yibin.entiy.Student;
@Service("oneservice")
public class OneServiceImpl implements OneToManyServices {
	@Autowired
    private StudentMapper stmapper;
	@Override
	public Student queryStudentById(int id) {
		// TODO Auto-generated method stub
		return stmapper.queryStudentById(id);
	}

}
