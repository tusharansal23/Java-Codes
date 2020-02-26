package com.nagarro.Entity;

import javax.persistence.Id;

//@XmlRootElement
@javax.persistence.Entity
public class Entity {
	@Id
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
		return "Entity [ecode=" + ecode + ", ename=" + ename + ", location=" + location + ", eid=" + eid + ", dob="
				+ dob + "]";
	}

}
