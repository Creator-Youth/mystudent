package com.hugeyurt.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hugeyurt.springAOP.IAopDemo;

public class TestXMLAspect {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  ApplicationContext appContext = new ClassPathXmlApplicationContext(
	                new String[] { "applicationContext.xml" });
		// 1 ��spring�����������
		IAopDemo demo = (IAopDemo) appContext.getBean("serviceDemo");
		// 2 ִ�з���
		 demo.printA();
		 
		 //Point point = (Point) appContext.getBean("point");
		// System.out.println(point.toString());
	}

}
