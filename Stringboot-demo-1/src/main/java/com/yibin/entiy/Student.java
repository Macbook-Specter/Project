package com.yibin.entiy;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
@Data
@Entity
@Table(name="student")
public class Student {
    @Id
   private int id;
   private String name;
   private int age;
   private String classs;
   @Transient
   private List<Books> books;

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", age=" + age + ", classs=" + classs + ", books=" + books + "]";
}
   public int getId() {
	return id;
}public String getName() {
	return name;
}public int getAge() {
	return age;
}public String getClasss() {
	return classs;
}
public List<Books> getBooks(){
	return books;
}
   
}
