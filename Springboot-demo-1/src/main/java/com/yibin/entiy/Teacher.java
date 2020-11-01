package com.yibin.entiy;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity(name="t_teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	@Column
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER) 
    @JoinTable(name = "t_p",uniqueConstraints ={@UniqueConstraint(columnNames = {"p_id","t_id"})},
    joinColumns = {@JoinColumn(name="t_id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name="p_id",referencedColumnName = "no")} )
	private List<Pupil> pupils=new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Pupil> getPupils() {
		return pupils;
	}
	public void setPupils(List<Pupil> pupils) {
		this.pupils = pupils;
	}
	public Teacher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Teacher() {
		super();
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", pupils=" + pupils + "]";
	}
	
	
}
