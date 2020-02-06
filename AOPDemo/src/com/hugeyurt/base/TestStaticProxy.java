package com.hugeyurt.base;

public class TestStaticProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IHello target=new Hello();
		target.sayHello("just a demo");
		target = new ProxyHello(target);
		
		//target.sayHello("kitty");
		target.sayHello(" kitty"); 
		
		//hello.sayBye();
		
	}

}
