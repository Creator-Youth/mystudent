package com.hugeyurt.jdkaop;

public class Logger implements ILogger{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("logger is starting...99999");
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		System.out.println("logger is ending...88888");
	}

}
