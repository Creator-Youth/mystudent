package com.hugeyurt.springAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
   
  @SuppressWarnings("resource")
public static void main(String[] args) 
   {
     ApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[] { "beans.xml" });

     
        
        
     IAopDemo demo =(IAopDemo) appContext.getBean("demoService");
   
    System.out.println(demo.getClass().getName());
    System.out.println(demo instanceof IAopDemo);
    System.out.println(demo.getClass().getSuperclass().getName());
   
    System.out.println("------------------------------------");
    demo.printA();
    System.out.println("------------------------------------");
    ServiceDemo2 demo2 =(ServiceDemo2) appContext.getBean("demoService2");
    
    System.out.println(demo2.getClass().getName());
    System.out.println(demo2 instanceof IAopDemo);
    System.out.println(demo2.getClass().getSuperclass().getName());
    
    
    
    //UserInfo userInfo=(UserInfo)appContext.getBean("userInfo");
   // userInfo.print();
    
        /* System.out.println("----------------------------");
        UserInfo user=new UserInfo();
        user.print();
        System.out.println(user.getClass());
        
        System.out.println("*************************");
       UserInfo userInfo=(UserInfo)appContext.getBean("userInfo");
       /*  
        userInfo.print();
          
        System.out.println(userInfo.getClass());
        System.out.println(userInfo instanceof UserInfo);
        System.out.println(userInfo.getClass().getSuperclass());
        
        Class clz=userInfo.getClass();
        Method[] methods=clz.getDeclaredMethods();
         for (Method method : methods) {
			System.out.println(method.getName());
		}
        
       /* ServiceDemo2 demo=(ServiceDemo2) appContext.getBean("demoService2");
        System.out.println(demo.getClass());
        demo.printName();
        demo.printURL();*/
        
      
        
       /* System.out.println("*************************");
        demo.printURL();
        System.out.println("*************************");*/
        

    }
}





