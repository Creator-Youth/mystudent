package app;

import java.util.Scanner;

public class Main1 {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		 Scanner reader =new Scanner(System.in);
         int N=reader.nextInt();         
         Max(N);  
	}
	 public static void Max(int N)
	    {     	
	    	if(N<=2)      System.out.println(N);  	    	
	    	if(N>=3)
	    	{
	    		int amount[]=new int[N+1];   	
	    	    for (int i=0;i<=N;i++)
	                {        	
	        		    amount[i]=0;      	          
	                }
	    	    amount[1]=1; 
	    	    amount[2]=2; 	    	   
	    	    for (int i=3;i<=N;i++)
	                {        		        	       		
	        		    amount[i]=amount[i-1]+amount[i-2]+1; 	        		    
	                }              
	            System.out.print(amount[N]);
	        }
	    }

}
