package com.hugeyurt.base;

import java.lang.reflect.Method;

public class App2 {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Hello hello=new Hello();
         Class clz=hello.getClass();
         try{
            @SuppressWarnings("unchecked")
			Method method=clz.getDeclaredMethod("sayHello", String.class);
            method.invoke(hello, "i like java");
         }catch(Exception e)
         {
        	 e.printStackTrace();
         }
	}

}
