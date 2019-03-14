package com.ziyou.domain;

import java.util.Date;

/**
 * 这是学生封装的对象bean
 * @author 梓游
 * */
public class Student {
	private int sid;
	private String sname;
	private String gender;
	private String phone;
	private String hoby;
	private String info;
	private Date birthday;
	
	
	public Student(String sname, String gender, String phone, String hoby, String info, Date birthday) {
		super();
		this.sname = sname;
		this.gender = gender;
		this.phone = phone;
		this.hoby = hoby;
		this.info = info;
		this.birthday = birthday;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHoby() {
		return hoby;
	}
	public void setHoby(String hoby) {
		this.hoby = hoby;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Student() {
		super();
	}
	
}
