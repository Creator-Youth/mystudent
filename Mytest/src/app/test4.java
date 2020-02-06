package app;

public class test4 {

	public static void main(String[] args)
	{
		int x=15,y=9;
		System.out.println("X是"+x+"，Y是"+y);		
		x=x^y;
		y=x^y;
		x=x^y;
		System.out.print  ("X是   "+x+"，Y是"+y);	
	}

}
