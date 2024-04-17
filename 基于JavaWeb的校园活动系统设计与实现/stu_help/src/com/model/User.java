package com.model;

import java.sql.Date;

public class User {
	private int sno;
	private String pwd;
	private String name;
	private String sex;
	private String college;
	private Date time;
	private int account;
	private int status;

	public User() {
	}

	public User(int sno,String pwd, String name, String sex, String college, Date time) {
		this.sno = sno;
		this.pwd = pwd;
		this.name = name;
		this.sex = sex;
		this.college = college;
		this.time = time;
	}

	public User(String college) {
		this.college = college;
	}

	public User(int sno, String pwd, String name, String sex, String college, Date time, int account, int status) {
		this.sno = sno;
		this.pwd = pwd;
		this.name = name;
		this.sex = sex;
		this.college = college;
		this.time = time;
		this.account = account;
		this.status = status;
	}

	public User(int sno, String name, String sex, String college) {
		this.sno = sno;
		this.name = name;
		this.sex = sex;
		this.college = college;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
