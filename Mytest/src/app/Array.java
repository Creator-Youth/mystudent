package app;

public class Array
{

	public static void test2(int i)
	{
		int temp=2;
		for (int j=1;j<i;j++)
		{
			temp=2*temp;
		}
		System.out.print(temp);
		
	}
	public static int test(int data[])
	
	{
		int temp=data[0];
		for (int i=1;i<data.length;i++)
		{
			temp=temp^data[i];
		}
		//System.out.println(temp^0);
		for (int i=1;i<data.length;i++)
		{
			temp=temp^data[i];
		}
		return temp;
	}
	public static void main(String[] args) 
	{
		//int data[]={1,2,2,1,3,4};
		//System.out.print(test(data));
		test2(30);
	}

}
