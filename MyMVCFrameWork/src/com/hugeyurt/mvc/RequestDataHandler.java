package com.hugeyurt.mvc;

import java.lang.reflect.Field;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDataHandler
{

	public static Object[] handlerRequest(HttpServletRequest request,	HttpServletResponse response,	
			Class paramTypes[],String[] paramNames)
	{
		Object  values[]=new Object[paramTypes.length];
		for(int i=0;i<paramTypes.length;i++)
		{
			if(checkInterface(paramTypes[i],request.getClass().getInterfaces()))
				values[i]=request;
			else if(checkInterface(paramTypes[i],request.getSession().getClass().getInterfaces()))
				values[i]=request.getSession();
			else if(checkInterface(paramTypes[i],response.getClass().getInterfaces()))
				  values[i]=response;
			else if(paramTypes[i]==String.class)
				values[i]=(String) request.getParameter(paramNames[i]);
			else if(paramTypes[i]==Integer.class)
				values[i]=Integer.valueOf((String) request.getParameter(paramNames[i]));
			else  if(paramTypes[i]==Double.class)
				values[i]=Double.valueOf((String) request.getParameter(paramNames[i]));
			else  if(paramTypes[i]==Boolean.class)
			   values[i]=Boolean.valueOf((String) request.getParameter(paramNames[i]));	
			else
		      {
				values[i]=toObject(paramTypes[i],request);   
			 }				
		}		
		return values;
	}
	
	private static boolean checkInterface(Class clz,  Class interfaces[])
	{
		if(clz==null||interfaces==null) return false;
		for(int i=0;i<interfaces.length;i++)
		   if(clz==interfaces[i]) return true;
		return false;
	}
	
    private static Object toObject(Class clz,  
                 HttpServletRequest request)
    {
    	Object object=null;
    	Enumeration<String> names=request.getParameterNames();
    	try{
    		object=clz.newInstance();
    		while(names.hasMoreElements())
    		{
    			String paramName=names.nextElement();
    			Field field=null;
    			try{
    				field=clz.getDeclaredField(paramName);
    			}catch(Exception e)
    			{
    				e.printStackTrace();
    			}
    			if(field==null) continue;
    			field.setAccessible(true);
    			String value=(String)request.getParameter(paramName);
    			if(field.getType()==Integer.class||
    				field.getType()==Integer.TYPE)
                 field.set(object, Integer.parseInt(value));
    			else if(field.getType()==Double.class||
        				field.getType()==Double.TYPE)
                    field.set(object, Double.parseDouble(value));
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
