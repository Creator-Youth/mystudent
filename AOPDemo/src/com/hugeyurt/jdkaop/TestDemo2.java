package com.hugeyurt.jdkaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  IDemo2 rs=new Demo2();//这里指定被代理类  
	      InvocationHandler ds=new DynDemo(rs); 
	      rs.print();
	      Class<?> cls=rs.getClass(); 
	      IDemo2 subject=(IDemo2) Proxy.newProxyInstance(  
	                cls.getClassLoader(),cls.getInterfaces(), ds); 
	      
	      subject.print();
	}

}
