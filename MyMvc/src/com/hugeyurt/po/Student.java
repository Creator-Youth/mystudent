package com.hugeyurt.po;

import java.util.List;

public class Student 
{
	private String sno;
	private String sname="";
	private String sex="";
	private String pwd="";
	private Card card;
	private ClassInfo classInfo;
	private List<SC>  scs;
	
	
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
	/*@Override
	public String toInsert() {
		// TODO Auto-generated method stub
	 String sql="insert into student(sno,sname,age,sex,cardID,dept)values('";
	 sql=sql+this.sno+"','"+this.sname+"',"+this.age+",'"+this.sex+"','";
	 sql=sql+this.cardID+"','"+this.dept+"')";
	
	 StringBuffer  stf=new StringBuffer("insert into student(sno,sname,age,sex,cardID,dept)values('");
	 stf.append(this.sno).append("','").append(this.sname);
	 stf.append("','").append(this.age).append("','");
	 stf.append(this.sex).append("','").append(this.cardID).append("','").append(this.dept);
	 stf.append("')");
	  
	 return stf.toString();
	}
	
	
	@Override
	public Object toObject(ResultSet rs) {
		// TODO Auto-generated method stub
		Student stu=null;
		if(rs==null) return null;
		try{
		stu=new Student();
		stu.setSno(rs.getString("sno"));
		stu.setSname(rs.getString("sname"));
		stu.setSex(rs.getString("sex"));
		stu.setAge(rs.getInt("age"));
		stu.setDept(rs.getString("dept"));
		stu.setCardID(rs.getInt("cardID"));
		}catch(Exception e)
		{
			
		}
		return stu;
	}*/
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public ClassInfo getClassInfo() {
		return classInfo;
	}
	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}
	public List<SC> getScs() {
		return scs;
	}
	public void setScs(List<SC> scs) {
		this.scs = scs;
	}
    
}
