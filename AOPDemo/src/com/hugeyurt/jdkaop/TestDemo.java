package com.hugeyurt.jdkaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

//客户端：生成代理实例，并调用了say()方法  
public class TestDemo {  
  
  public static void main(String[] args) throws Throwable{  
        // TODO Auto-generated method stub  
  
      IDemo target=new Demo();//这里指定被代理类  
        
      InvocationHandler ds=new DynDemo(target); 
      
      System.out.println("target："+ ds);
       
       Class<?> cls=target.getClass();  
          
     //以下是一次性生成代理  
      IDemo subject=(IDemo)Proxy.newProxyInstance(  
                cls.getClassLoader(),cls.getInterfaces(), ds); 
      //subject.say();
            
        //这里可以通过运行结果证明subject是Proxy的一个实例，这个实例实现了IDemo接口  
       /// System.out.println(subject instanceof Proxy);  
          
        //这里可以看出subject的Class类是$Proxy0,这个$Proxy0类继承了Proxy，实现了IDemo接口  
       //System.out.println("subject的Class类是："+subject.getClass().getName());  
      // System.out.println("subject的Class父类是："+subject.getClass().getSuperclass().getName());  
       // System.out.println(arg0);
      /*
       System.out.println("subject中的属性有：");  
          
        Field[] field=subject.getClass().getSuperclass().getDeclaredFields();  
        for(Field f:field){  
            System.out.print(f.getName()+", "+f.getType()+" # ");
            f.setAccessible(true);
            System.out.println(f.get(subject)+"  #"+f.getModifiers());
        }  
          /*
       System.out.println("subject中的方法有：");  
          
        Method[] method=subject.getClass().getDeclaredMethods();  
          
        for(Method m:method){  
            System.out.print(m.getName()+", ");  
        }  
          
       // System.out.println("\n"+"subject的父类是："+subject.getClass().getSuperclass());  
         
       System.out.println("\n"+"subject实现的接口是：");  
          
        Class<?>[] interfaces=subject.getClass().getInterfaces();  
          
        for(Class<?> i:interfaces){  
            System.out.print(i.getName()+", ");  
        }  */
  
        System.out.println("\n\n"+"运行结果为：");  
        subject.say();  
        subject.hello();
        
    }  
}  


