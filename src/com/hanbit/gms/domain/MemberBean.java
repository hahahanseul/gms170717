package com.hanbit.gms.domain;

import java.io.Serializable;

public class MemberBean implements Serializable{
	private static final long serialVersionUID=1L;
   private String id, pw, name, ssn, regdate; 
   public String getRegdate() {
	return regdate;
}


public void setRegdate(String regdate) {
	this.regdate = regdate;
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public String getPw() {
	return pw;
}


public void setPw(String pw) {
	this.pw = pw;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getSsn() {
	return ssn;
}


public void setSsn(String ssn) {
	this.ssn = ssn;
}


@Override
public String toString() {
	return "MemberBean [id=" + id + ", pw=" + pw + ", name=" + name + ", ssn=" + ssn + ", regdate=" + regdate + "]"+"\n";
}



   
}