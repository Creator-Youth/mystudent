package com.hugeyurt.po;

import org.springframework.stereotype.Repository;

@Repository
public class enter
{
     private  String sno;
     private  String passname;
     private  int count;
     private  long time;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getPassname() {
		return passname;
	}
	public void setPassname(String passname) {
		this.passname = passname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}

	public String toString() {
		return "enter [sno=" + sno +  "]";
	}
	static public int sum()
	{
		return 4;
	}
}
