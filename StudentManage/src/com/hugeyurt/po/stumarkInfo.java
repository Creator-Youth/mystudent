package com.hugeyurt.po;

import org.springframework.stereotype.Repository;

@Repository
public class stumarkInfo 
{
	public String markid;
	public String stuid;
	public String coursename;
	public int    basescore;
	public int    testscore;
	public double finalscore;
	public String adddate;
	public String note;
	
	public stumarkInfo()
	{
		
	}

	public String getMarkid() {
		return markid;
	}

	public void setMarkid(String markid) {
		this.markid = markid;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public String getCouresename() {
		return coursename;
	}

	public void setCouresename(String couresename) {
		this.coursename = couresename;
	}

	public int getBasescore() {
		return basescore;
	}

	public void setBasescore(int basescore) {
		this.basescore = basescore;
	}

	public int getTestscore() {
		return testscore;
	}

	public void setTestscore(int testscore) {
		this.testscore = testscore;
	}

	public double getFinalscore() {
		return finalscore;
	}

	public void setFinalscore(double finalscore) {
		this.finalscore = finalscore;
	}

	public String getAdddate() {
		return adddate;
	}

	public void setAdddata(String adddate) {
		this.adddate = adddate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
