package com.hugeyurt.base;
/*
 * 静态代理模式实现AOP
 * 
 */
public class ProxyHello implements IHello {
    
	private IHello target;
    
    public ProxyHello(IHello target)
    {
        	this.target=target;
    }
    
	@Override
	public void sayHello(String str) {
		// TODO Auto-generated method stub
		Logger.start();
		target.sayHello(str);// 代用被代理的方法
		Logger.end();
	}

	@Override
	public void sayBye() {
		// TODO Auto-generated method stub
		target.sayBye();
	}

}



