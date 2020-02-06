package com.hugeyurt.jdkaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//ʵ����InvocationHandler  
// DynDemo ��һ��������
public class DynDemo implements InvocationHandler  
{  
	// ��ʱOBJ��Ҫ������Ķ���
    private Object obj;
    private ILogger ilogger=new Logger(); //��ʱ��Ӳ����
   // private MethodBeforeAdvice  before=null;
    //���Ƕ�̬����ĺô�������װ�Ķ�����Object���ͣ������������͵Ķ���  
  
    public DynDemo()  
    {  
    }  
  
    // ��ʱ����obj��Ҫ������Ķ���
    public DynDemo(Object obj)  
    {  
        this.obj = obj;  
    }  
  
    //�����������������ʾ��ȥ����  
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable  
    {  
    	//System.out.println("*************njupt*****************");
    	
    	System.out.println(method.getName());
    	
    	if(method.getName().equals("hello"))
    	{
    		 method.invoke(obj, args);  
    		 return null;
    	}
    	
        //System.out.println("before calling " + method);  
    	//if(before!=null) before.before(arg0, arg1, arg2);
        ilogger.start();
        method.invoke(obj, args);  // ִ�б��������������
        ilogger.end();
        //System.out.println("after calling " + method);  
  
        return null;  
    }  
  
}  
