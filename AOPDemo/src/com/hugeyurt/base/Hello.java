package com.hugeyurt.base;

public class Hello implements IHello{

	@Override
	public void sayHello(String str) {
		// TODO Auto-generated method stub
		System.out.println("hello : "+str);
	}

	@Override
	public void sayBye() {
		// TODO Auto-generated method stub
		System.out.println("bye bye");
	}

}
