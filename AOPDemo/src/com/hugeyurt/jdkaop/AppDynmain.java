package com.hugeyurt.jdkaop;

import java.lang.reflect.Method;

public class AppDynmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
          Demo demo=new Demo();
          DynDemo dyDemo=new DynDemo(demo);
          Method method=demo.getClass().getDeclaredMethod("say");
          dyDemo.invoke(dyDemo, method, null);
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
	}

}
