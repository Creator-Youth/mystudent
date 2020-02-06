package com.hugeyurt.jdkaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//实现了InvocationHandler  
// DynDemo 是一个代理类
public class DynDemo implements InvocationHandler  
{  
	// 此时OBJ是要被代理的对象
    private Object obj;
    private ILogger ilogger=new Logger(); //此时是硬编码
   // private MethodBeforeAdvice  before=null;
    //这是动态代理的好处，被封装的对象是Object类型，接受任意类型的对象  
  
    public DynDemo()  
    {  
    }  
  
    // 此时参数obj是要被代理的对象
    public DynDemo(Object obj)  
    {  
        this.obj = obj;  
    }  
  
    //这个方法不是我们显示的去调用  
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
        method.invoke(obj, args);  // 执行被代理对象的切入点
        ilogger.end();
        //System.out.println("after calling " + method);  
  
        return null;  
    }  
  
}  
