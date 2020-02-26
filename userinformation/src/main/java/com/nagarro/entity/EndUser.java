package com.nagarro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EndUser {
	@Id
	private String uname;
	private String password;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EndUser [uname=" + uname + ", password=" + password + "]";
	}

}
