package app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main
{
    @SuppressWarnings("resource")
	public static void main(String[] args)
       {
    	 
    	   String s2=new String("abc");
    	   s2=s2.intern();
    	   String s1="abc";
    	   System.out.println(s1==s2);//false
    	   
    	   
           // Scanner reader =new Scanner(System.in);         
          /*  int m=reader.nextInt();
            Integer i=null;
            int y=0;
            List<Integer> list=new ArrayList<Integer >();*/
          /*  int data[]=new int[m]; 
            {
            	for(int i=0;i<m;i++)
            	{
            		data[i]=reader.nextInt();
            	}
            }
            //data��Ŷ����������۵�
            int N=reader.nextInt();//��Ǯ��
            Max(data,N);   //���ֵ    
            */ 
          /*  Integer i=100;
            int j=100;
            System.out.print("Integer i=100;  int       j=100;����i==j,�Զ�������װ��--->");
            System.out.println(i==j);             
            Integer ii=100;
            Integer jj=100;
            System.out.print("Integer ii=100; Integer  jj=100;����ii==jj,��װ��Ƚ�--->");
            System.out.println(ii==jj);
            Integer iii=200;
            Integer jjj=200;
            System.out.print("Integer iii=200;Integer jjj=200;����iii==jjj,��װ��Ƚ�--->");
            System.out.println(iii==jjj);
            i=200;
            j=200;
            System.out.print(" i=100;j=100;����i==j,--->");
            System.out.println(i==j);*/
      }      
    
    public static void Max(int data[],int N)
    {   int max=0;  	
    	for (int i=0;i<=data.length;i++)
        {        	
        		if(data[i]>max)max=data[i];      	          
        }   	
    	if(N<max)System.out.print(-1);//�ж�����
    	
    	int amount[]=new int[N+1];   	
    	for (int i=0;i<=N;i++)
        {        	
        		amount[i]=N+1;      	          
        }
    	amount[0]=0; 
    	for (int i=0;i<=N;i++)
        {        	
        	for(int j=0;j<data.length;j++)
        	{
        		if(i-data[j]<0)
        		{
        			continue;
        		}        		
        		amount[i]=Math.min(amount[i],1+amount[i-data[j]]);        		
        	}
        }      
    	if(amount[N]==N+1)System.out.print(-1);
        System.out.print(amount[N]);
    }
}