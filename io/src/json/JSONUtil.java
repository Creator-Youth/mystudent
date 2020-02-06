package json;

import java.lang.reflect.Field;

public class JSONUtil 
{
   @SuppressWarnings("rawtypes")
public static String toString (Object object) throws IllegalArgumentException, IllegalAccessException
   {  
	   if(object==null) return null;
	   StringBuffer st=new StringBuffer(250);
       Class clz=object.getClass();//�õ��������
       Field[] fi=clz.getDeclaredFields();//�õ����������
       st.append("{");
       for (Field field : fi) 
       {
		  String key=field.getName();//�õ������������
		  field.setAccessible(true);//���÷���Ȩ��
		  Object value=field.get(object);//��object�õ������Զ�Ӧ��ֵ
		  st.append("\""+key+"\""+":");
		  st.append(value.toString());
		  st.append(",");  
	   }
	   int last=st.lastIndexOf(",");//�õ����һ����������λ��
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
