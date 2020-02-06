package com.hugeyurt.springAOP;


public class ServiceDemo2 {
	
    private String name="hzhqian";
    private String url;

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public  void printName() {
        System.out.println("name : " + this.name);
    }

    public void printURL() {
        System.out.println("company : " + this.url);
    }

    public void printThrowException() {
        throw new IllegalArgumentException();
    }

	

}


