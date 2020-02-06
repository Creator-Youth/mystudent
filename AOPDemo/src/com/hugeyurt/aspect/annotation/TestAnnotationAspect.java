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
		// 1 ��spring�����������
		ServiceDemo demo = (ServiceDemo) appContext.getBean("serviceDemo");
		// 2 ִ�з���
		 demo.printName();
	}

}
