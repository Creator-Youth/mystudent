package app;

public class Main3
{
	 static int sum=0;
	 public static void main(String[] args)
	    {
		 
	        int[] arr = { 1, 2, 3, 4 ,5};
	        fullSort(arr, 0, arr.length - 1);
	        System.out.print(sum);
	    }

	    public static void fullSort(int[] arr, int start, int end)
	    {
	        // 递归终止条件
	        if (start == end) 
	        {
	        	System.out.print("array变成了一次全排列的");
	            for (int i : arr)
	            {
	                System.out.print(i);
	                
	            }
	            System.out.println("++");
	            sum+=1;
	            return;
	        }//
	        
	        
	        for (int i = start; i <= end; i++) 
	        {
	            swap(arr, i, start);
	            fullSort(arr, start + 1, end);
	            swap(arr, i, start);
	        }
	    }

	    private static void swap(int[] arr, int i, int j) 
	    {
	        int tmp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = tmp;
	    }

	
}
