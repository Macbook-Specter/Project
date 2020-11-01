package com.yibin.entiy;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity(name = "t_pupil")
public class Pupil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
	@Column
    private String name;
	@Column
    private String sex;
	
    @ManyToMany(mappedBy = "pupils")
    public List<Teacher> teachers=new ArrayList<>();
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public Pupil(int no, String name, String sex) {
		super();
		this.no = no;
		this.name = name;
		this.sex = sex;
	}
	public Pupil() {
		super();
	}
	@Override
	public String toString() {
		return "Pupil [no=" + no + ", name=" + name + ", sex=" + sex + "]";
	}
	
}
