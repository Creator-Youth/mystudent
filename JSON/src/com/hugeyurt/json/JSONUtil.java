package com.hugeyurt.json;

import java.lang.reflect.Field;
import java.util.HashMap;

public class JSONUtil 
{
	@SuppressWarnings("rawtypes")
	public static String toJson(Object object)//自己实现JSON
	{
		if(object==null) return null;
		StringBuffer stf=new StringBuffer(250);
		Class clz=object.getClass();
		Field[] fields=clz.getDeclaredFields();
		stf.append("{");
		try
		{
		  for (Field field : fields) 
		  {
			String key=field.getName();
			field.setAccessible(true);
			Object value=field.get(object);
			stf.append("\""+key+"\":");
			if(field.getType()==Integer.class||field.getType()==Integer.TYPE)
				stf.append(Integer.parseInt(value.toString())).append(",");
			else if (field.getType()==Double.class||field.getType()==Double.TYPE)
			stf.append(Double.parseDouble(value.toString())).append(",");
			else if (field.getType()==Boolean.class||field.getType()==Boolean.TYPE)
				stf.append(value.toString()).append(",");
			else
				stf.append("\""+value.toString()+"\",");
			
		  }	
	     int index=stf.lastIndexOf(",");
	     stf.replace(index, index+1, "}");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return stf.toString();
	}
	
	@SuppressWarnings("rawtypes")
	public static Object toObject(String json,Class clz)//自己解析JSON
	{
		if(json==null||"".equals(json)||clz==null) return null;
		String stf=json.substring(1, json.length()-1);
		String kv[]=stf.split(",");
		Object object=null;
	   	if(kv.length==0) return null;
	   	HashMap<String,String> maps=new HashMap<String,String>();
	    for(int i=0;i<kv.length;i++)
		 {
		    String temp[]=kv[i].split(":");
		    if(temp[1].contains("\"")) temp[1]=temp[1].substring(1, temp[1].length()-1);
		    temp[0]=temp[0].substring(1, temp[0].length()-1);
		    maps.put(temp[0], temp[1]);
		 }
	   Field[] fields=clz.getDeclaredFields();
	   //if(fields.length!=maps.size()) return null;
	   try{
		   object=clz.newInstance();
	     for (Field field : fields) 
	     {
		     field.setAccessible(true);
		     String value=maps.get(field.getName());
		     if(value==null) continue;
		     if(field.getType()==Integer.class||field.getType()==Integer.TYPE)
		    	 field.set(object, Integer.parseInt(value));
		     else if(field.getType()==Double.class||field.getType()==Double.TYPE)
		    	   field.set(object, Double.parseDouble(value));
		     else if(field.getType()==Boolean.class||field.getType()==Boolean.TYPE)
		    	 field.set(object, Boolean.parseBoolean(value));
		     else
		    	 field.set(object, value); 
	     }
	   }catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   
	   return object;
	}

}
