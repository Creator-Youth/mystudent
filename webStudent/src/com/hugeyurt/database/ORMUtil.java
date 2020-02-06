package com.hugeyurt.database;

import java.lang.reflect.Field;
import java.sql.ResultSet;

public class ORMUtil 
{
	@SuppressWarnings("rawtypes")
	public static Object toObject(ResultSet rs,Class clz)
	{
		if(rs==null||clz==null) return null;
		
		Object object=null;
		try{
		    object=clz.newInstance();// 鍒涘缓涓�涓璞�
		    int cols=rs.getMetaData().getColumnCount();//鑾峰彇鍒楁暟
		    for(int i=0;i<cols;i++)
		    {
		       String fieldName=rs.getMetaData().getColumnName(i+1);//鑾峰彇鍒楀悕
		    	Object value=rs.getObject(fieldName);//鑾峰彇璇ュ垪鐨勫�硷紱
		   Field field=clz.getDeclaredField(fieldName);//鑾峰彇灞炴�у璞�
		    	field.setAccessible(true);//缁曡繃璁块棶鏉冮檺
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
			e.printStackTrace();
		}
			
		return object;
	}

	
	@SuppressWarnings("rawtypes")
	public static Object[] toInsert(StringBuffer stf,Object object)
	{
		Class clz=object.getClass();
		Field[] fields=clz.getDeclaredFields();
		Object[] params=new Object[fields.length];
		String tableName=clz.getSimpleName();//锟斤拷锟斤拷锟斤拷为锟斤拷锟斤拷
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
