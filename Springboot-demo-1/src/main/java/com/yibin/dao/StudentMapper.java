package com.yibin.dao;

import org.apache.ibatis.annotations.*;
import com.yibin.entiy.Student;


public interface StudentMapper {
	@Select("SELECT * FROM `student` WHERE id = #{id}")
	@Results({
         @Result(property = "books", column = "id",
                 many = @Many(select = "com.yibin.dao.BooksMapper.queryBooks"))
             })
    // 对student_id进行赋值
    @Result(property = "id", column = "id")
	public Student queryStudentById(int id);
}
