package app;
public class test3 {
    public static char[] replaceSpace(StringBuffer str) 
    {
    	int length=str.length();
        char c1[]=str.toString().toCharArray();
        for (int i=0;i<str.length();i++)
        {
            if (c1[i]==(char)' ')
            {
                length+=2;
            }
        }
        char array[]=new char[length];
        int j=0;
        for (int i=0;i<str.length();i++)
        {
            
            if (c1[i]==(char)' ')
            {
                array[j++]='%';
                array[j++]='2';
                array[j++]='0';
            }
            else 
            {
                array[j++]=c1[i];
            }
        }
      return array;
    }
    public int duplicate(int numbers[],int length,int [] duplication) 
    {
    	 int n=duplication.length;
         int j=0;
         int []in=new int[n];
         for (int i=0;i<n;i++)
         {
             in[i]=0;
         }
        for (int i=0;i<length;i++)
        {
            if(in[numbers[i]]==1)
            {
                j=numbers[i];
                break;
            }
            else 
            {
                in[numbers[i]]++;
            }
        }
        return j;
    }
}