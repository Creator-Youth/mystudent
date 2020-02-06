package com.hugeyurt.springAOP;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

public class DemoBeforeAdvice implements MethodBeforeAdvice
{
    @Override
    public void before(Method method, Object[] args, Object target)
        throws Throwable {
    	System.out.println("**********before****************");
    	   System.out.println(method.getName());
    	   System.out.println(target);
    	  // method.invoke(target, args);
    	// System.out.println("**************************");   
    	 
       System.out.println("BeforeMethod : Before method finished!");
    }
}



