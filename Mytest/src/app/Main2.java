//回文串问题
package app;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main2 
{
	public static int max=0;
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int left=0,right;
        for(int i=0;i<s.length();i++)
        {
        	
        	right=count(s,i,i);
        	right=count(s,i,i+1);
        	if(right!=0)
        	{
        		left=right;
        	}
        }
        System.out.print(s.substring(left, left + max));
	}
	public static int count(String s,int left,int right)
	{
		int ans=0;
		char array[]=s.toCharArray();
		{
			while(left>=0&&right<=array.length-1&&array[left]==array[right])
			{
				left--;
				right++;
				ans++;
				ans++;
			}		
	    }
		if (max<ans){max=ans;return left+1 ;	}
		else{return 0;}
	}
		
}
