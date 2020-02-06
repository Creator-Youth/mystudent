package com.hugeyurt.base;

import java.util.Date;

public class Logger {
	public static void start()
	{
		System.out.println(new Date()+" Say hello start");
	}
	public static void end()
	{
		System.out.println(new Date()+" Say hello end");
	}
}
