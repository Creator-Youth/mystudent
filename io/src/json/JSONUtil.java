package json;

import java.lang.reflect.Field;

public class JSONUtil 
{
   @SuppressWarnings("rawtypes")
public static String toString (Object object) throws IllegalArgumentException, IllegalAccessException
   {  
	   if(object==null) return null;
	   StringBuffer st=new StringBuffer(250);
       Class clz=object.getClass();//得到对象的类
       Field[] fi=clz.getDeclaredFields();//得到对象的属性
       st.append("{");
       for (Field field : fi) 
       {
		  String key=field.getName();//得到对象的属性名
		  field.setAccessible(true);//设置访问权限
		  Object value=field.get(object);//从object得到该属性对应的值
		  st.append("\""+key+"\""+":");
		  st.append(value.toString());
		  st.append(",");  
	   }
	   int last=st.lastIndexOf(",");//得到最后一个，号所在位置
	   st.replace(last, last+1, "}");
	   return st.toString();
   }
   @SuppressWarnings("rawtypes")
public static Object toObject(String Json,Class clz) throws InstantiationException, IllegalAccessException
   {
	   if(Json==null||clz==null) return null;
	   clz.newInstance();
	   return null;
   }
}
