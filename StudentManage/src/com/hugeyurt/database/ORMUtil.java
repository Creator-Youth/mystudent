package com.hugeyurt.database;

import java.lang.reflect.Field;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
public class ORMUtil 
{
	public  Object toObject(ResultSet rs,Class<?> clz)
	{
		if(rs==null||clz==null) return null;
		
		Object object=null;
		try{
		    object=clz.newInstance();//创建对象
		    int cols=rs.getMetaData().getColumnCount();
		    for(int i=0;i<cols;i++)
		    {
		        String fieldName=rs.getMetaData().getColumnName(i+1);
		    	Object value=rs.getObject(fieldName);
		        Field field=clz.getDeclaredField(fieldName);
		    	field.setAccessible(true);
		 if(field.getType()==Integer.class||field.getType()==Integer.TYPE)
		    	field.set(object, Integer.parseInt(value.toString()));
		 else if(field.getType()==Double.class||field.getType()==Double.TYPE)
			 field.set(object, Double.parseDouble(value.toString()));
		 else if(field.getType()==Float.class||field.getType()==Float.TYPE)
			 field.set(object, Float.parseFloat(value.toString()));
		 else  field.set(object, value);
		    }
		      
		}catch(Exception e)
		{
			
		}
			
		return object;
	}

	
	@SuppressWarnings("rawtypes")
	public static  Object[] toInsert(StringBuffer stf,Object object)
	{
		Class clz=object.getClass();
		Field[] fields=clz.getDeclaredFields();
		Object[] params=new Object[fields.length];
		String tableName=clz.getSimpleName();
		stf.append("insert into ").append(tableName).append("(");
		try{
		for(int i=0;i<fields.length;i++)
		{
		    fields[i].setAccessible(true);
		    params[i]=fields[i].get(object);
		    stf.append(fields[i].getName()).append(",");
		    
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		int index=stf.lastIndexOf(",");
		stf.replace(index, index+1, ")values(");
		for(int i=0;i<fields.length;i++)
		   stf.append("?,");
	    index=stf.lastIndexOf(",");
		stf.replace(index, index+1, ")");		
		return params;
	}
}
