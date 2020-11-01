package com.yibin.entiy;


import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "books")
@Table(name = "books")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	private int number;  //书籍编号
	@Column
   	private String bookname;
	@Column
   	private Double price;
	@Column
   	private int student_id;

public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public int getStudent_id() {
	return student_id;
}
public void setStudent_id(int student_id) {
	this.student_id = student_id;
}
  

}
