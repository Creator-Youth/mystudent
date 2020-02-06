package com.hugeyurt.service;

import java.util.ArrayList;

public interface page {

	public abstract ArrayList<Object> viewSomeStudent(int startpage,int pagesize);
	public  abstract int  getStart();
}
