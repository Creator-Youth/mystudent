package com.hugeyurt.base;
/*
 * ��̬����ģʽʵ��AOP
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
		target.sayHello(str);// ���ñ�����ķ���
		Logger.end();
	}

	@Override
	public void sayBye() {
		// TODO Auto-generated method stub
		target.sayBye();
	}

}



