package com.yibin.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.yibin.entiy.Pupil;

public interface PupilRepository extends JpaRepository<Pupil, Integer> {
	
}
