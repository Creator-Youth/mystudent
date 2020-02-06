package app;

import java.util.Scanner;

public class mytest5
{
	public static void Swap(int data)
	{
		StringBuffer buffer=new StringBuffer();
		
		while (data>0)
		{
			buffer.append(data%2);
			data=data/2;
		}
		System.out.print(buffer.reverse().toString());
		
	}

	public static void main(String[] args) 
	{		
		
		Scanner in=new Scanner(System.in);
		int data=in.nextInt();
		Swap(data);

	}

}
