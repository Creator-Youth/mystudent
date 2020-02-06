package com.hugeyurt.jdkaop;

public class UserInfo {
	private String userID="njupt2018";
	private String userName;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void print()
	{
		System.out.println(this.userID);
	}
	

}
