package com.hugeyurt.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AppArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String jsons="[{\"x\":\"kk\",\"y\":2},{\"x\":\"bb\",\"y\":3}]";//Point(x,y)
        JSONArray  tjson=JSONArray.fromObject(jsons);
//        Object[]  lists=(Object[])tjson.toArray(tjson, Point.class);
//        for(int i=0;i<lists.length;i++)
//          System.out.println(lists[i]);
         Object[] objs=tjson.toArray();
         Object object=objs[0];        
		 JSONObject t=(JSONObject)object;
		 Point point=(Point)JSONObject.toBean(t, Point.class);
		 System.out.println(point.getX());
		 //Êä³öKK
		
	}

}
