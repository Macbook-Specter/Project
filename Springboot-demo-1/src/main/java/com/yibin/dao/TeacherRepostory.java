package com.yibin.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yibin.entiy.Teacher;

public interface TeacherRepostory extends JpaRepository<Teacher, Integer> {
}
