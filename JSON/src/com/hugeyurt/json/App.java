package com.hugeyurt.json;

import net.sf.json.JSONObject;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Point point=new Point("mm",4);
       JSONObject json=JSONObject.fromObject(point);
      ;
       System.out.println( json.get("x"));
       //System.out.println(JSONUtil.toJson(point));
	}

}
