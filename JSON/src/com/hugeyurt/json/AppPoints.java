package com.hugeyurt.json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

public class AppPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<Point> points=new ArrayList<Point>();
        points.add(new Point("kk",2));
        points.add(new Point("bb",3));
        JSONArray json=JSONArray.fromObject(points);
        System.out.println(json);
        
	}

}
