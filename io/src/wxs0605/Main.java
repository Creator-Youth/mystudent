package wxs0605;
public class Main 
{	
	    public static void main(String[] args)
	    {
	        int[] arr = { 1, 2, 3, 4 };
	        fullSort(arr, 0, arr.length - 1);
	    }

	    public static void fullSort(int[] arr, int start, int end)
	    {
	        // 递归终止条件
	        if (start == end) 
	        {
	            for (int i : arr)
	            {
	                System.out.print(i);
	            }
	            System.out.println("++");
	            return;
	        }
	        for (int i = start; i <= end; i++) //首位1234，再对其他进行全排列。
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