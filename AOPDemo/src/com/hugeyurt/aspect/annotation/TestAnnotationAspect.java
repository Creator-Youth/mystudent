package com.hugeyurt.aspect.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hugeyurt.aspect.annotation.ServiceDemo;

public class TestAnnotationAspect {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  ApplicationContext appContext = new ClassPathXmlApplicationContext(
	                new String[] { "beansAnnotation.xml" });
		// 1 从spring容器获得内容
		ServiceDemo demo = (ServiceDemo) appContext.getBean("serviceDemo");
		// 2 执行方法
		 demo.printName();
	}

}
