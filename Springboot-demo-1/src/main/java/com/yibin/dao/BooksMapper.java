package com.yibin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.yibin.entiy.Books;

@Mapper
public interface BooksMapper {
	@Select(value = { "SELECT * FROM `books` WHERE student_id = #{student_id}" })
	public List<Books> queryBooks(Double student_id);
}
