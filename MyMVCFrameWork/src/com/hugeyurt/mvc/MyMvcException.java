package com.hugeyurt.mvc;

public class MyMvcException extends Exception
{
    private String errorMessage;
    
    public MyMvcException(String errorMessage)
    {
    	this.errorMessage=errorMessage;
    }
    
    @Override
    public void printStackTrace()
    {
    	System.out.println(this.errorMessage);
    }
}
