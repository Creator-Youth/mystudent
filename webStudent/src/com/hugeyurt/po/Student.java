package com.hugeyurt.po;

public class Student 
{
	private String sno;
	private String sname;
	private Integer sage;
	private Integer count;
	private String pwd;
	private String logintime;
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", sage=" + sage + ", count=" + count + ", pwd=" + pwd
				+ ", logintime=" + logintime + ", getSno()=" + getSno() + ", getSname()=" + getSname() + ", getSage()="
				+ getSage() + ", getCount()=" + getCount() + ", getPwd()=" + getPwd() + ", getLogintime()="
				+ getLogintime() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	

}
