package com.nagarro.entity;

import java.util.Date;

public class Employee {
	private int ecode;
	private String ename;
	private String location;
	private String eid;
	private String dob;

	public int getEcode() {
		return ecode;
	}

	public void setEcode(int ecode) {
		this.ecode = ecode;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [ecode=" + ecode + ", ename=" + ename + ", location=" + location + ", eid=" + eid + ", dob="
				+ dob + "]";
	}

}
