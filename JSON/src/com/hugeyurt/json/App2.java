package com.hugeyurt.json;

public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String json="{\"x\":\"mm\",\"y\":4.0}";
     Point point=(Point)JSONUtil.toObject(json, Point.class);
     
     System.out.println(point.toString());
     
	}

}
