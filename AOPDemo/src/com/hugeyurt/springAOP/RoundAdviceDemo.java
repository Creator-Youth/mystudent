package com.hugeyurt.springAOP;



import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;



public class RoundAdviceDemo implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("round demo....");
		Object object= arg0.proceed();
		System.out.println("after round demo....");
		return object;
	}



}
