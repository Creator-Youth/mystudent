package com.hugeyurt.jdkaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

//�ͻ��ˣ����ɴ���ʵ������������say()����  
public class TestDemo {  
  
  public static void main(String[] args) throws Throwable{  
        // TODO Auto-generated method stub  
  
      IDemo target=new Demo();//����ָ����������  
        
      InvocationHandler ds=new DynDemo(target); 
      
      System.out.println("target��"+ ds);
       
       Class<?> cls=target.getClass();  
          
     //������һ�������ɴ���  
      IDemo subject=(IDemo)Proxy.newProxyInstance(  
                cls.getClassLoader(),cls.getInterfaces(), ds); 
      //subject.say();
            
        //�������ͨ�����н��֤��subject��Proxy��һ��ʵ�������ʵ��ʵ����IDemo�ӿ�  
       /// System.out.println(subject instanceof Proxy);  
          
        //������Կ���subject��Class����$Proxy0,���$Proxy0��̳���Proxy��ʵ����IDemo�ӿ�  
       //System.out.println("subject��Class���ǣ�"+subject.getClass().getName());  
      // System.out.println("subject��Class�����ǣ�"+subject.getClass().getSuperclass().getName());  
       // System.out.println(arg0);
      /*
       System.out.println("subject�е������У�");  
          
        Field[] field=subject.getClass().getSuperclass().getDeclaredFields();  
        for(Field f:field){  
            System.out.print(f.getName()+", "+f.getType()+" # ");
            f.setAccessible(true);
            System.out.println(f.get(subject)+"  #"+f.getModifiers());
        }  
          /*
       System.out.println("subject�еķ����У�");  
          
        Method[] method=subject.getClass().getDeclaredMethods();  
          
        for(Method m:method){  
            System.out.print(m.getName()+", ");  
        }  
          
       // System.out.println("\n"+"subject�ĸ����ǣ�"+subject.getClass().getSuperclass());  
         
       System.out.println("\n"+"subjectʵ�ֵĽӿ��ǣ�");  
          
        Class<?>[] interfaces=subject.getClass().getInterfaces();  
          
        for(Class<?> i:interfaces){  
            System.out.print(i.getName()+", ");  
        }  */
  
        System.out.println("\n\n"+"���н��Ϊ��");  
        subject.say();  
        subject.hello();
        
    }  
}  


