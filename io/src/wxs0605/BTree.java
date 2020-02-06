package wxs0605;

import java.util.Scanner;
import java.util.Stack;


public class BTree 
{
     int data;
     BTree lchild;
     BTree rchild;
     
    public BTree()
 	{
 	}
 	
 	
 	public BTree(int data)
 	{
 		this.data=data;
 		this.lchild=this.rchild=null;
 	}
 	
 	public static BTree createBTree(int m)
 	{
 		@SuppressWarnings("resource")
		int array2[]=change();
 		BTree root=null;
 		
 		for(int k=0;k<array2.length;k++)
 		{
 			int mm=array2[k]=0;
 			if(mm<=0) return null;
 			root=new BTree(mm);
 			root.lchild=createBTree(mm);
 	 		root.rchild=createBTree(mm);
 		}
 		
 		return root;
 	}
 	
 	
 	public  void mid(BTree root)//�������
 	{
 		if(root==null)
 		{
 			return ;
 		}
 		Stack<BTree> stack=new Stack<BTree>();
 		while(root!=null)
 		{ 			
 			stack.push(root);
 			root=root.lchild;
 		}
 		
 		while (!stack.isEmpty())
 		{
 			root=stack.pop();
 			System.out.println(root.data);
 			if(root.rchild!=null)
 			{
 				    root=root.rchild;				
 				    while(root!=null)
 			 		{			 			
 			 			stack.push(root);
 			 			root=root.lchild;
 			 		}	 		 				
 			}
 		}
 	}
 	public static int[] change()
 	{
 		Scanner reader=new Scanner(System.in);
 		String str=reader.nextLine();
 		char []array1=str.toCharArray();
 		int  []array2=new  int[array1.length];
 		int i=0,j=0;
 		for(int k=0;k<array2.length;k++)
 		{
 			array2[k]=0;
 		}
 		while(j<array1.length)///             1(2(3,4(,5)),6(7,))
 		{
 			if(array1[j]=='(')
 			{			   		     
 				if
 				((array1[++j]=='1'
 				||array1[++j]=='2'
 				||array1[++j]=='3'
 				||array1[++j]=='4'
 				||array1[++j]=='5'
 				||array1[++j]=='6'
 				||array1[++j]=='7'
 				||array1[++j]=='8'
 				||array1[++j]=='9')&&array1[++j]==',')
 				{
 					array2[i++]=(int)array1[j];
 					array2[i++]=0;
					array2[i++]=0;
					j++;
 				}
 				if(      array1[++j]==',' &&(array1[++j]=='1'
 		 				||array1[++j]=='2'
 		 				||array1[++j]=='3'
 		 				||array1[++j]=='4'
 		 				||array1[++j]=='5'
 		 				||array1[++j]=='6'
 		 				||array1[++j]=='7'
 		 				||array1[++j]=='8'
 		 				||array1[++j]=='9'
 		 				))
 					{
 					    array2[i++]=0;
 					    array2[i++]=0;
 					    j++;
 					}
 			}
 			if (  array1[j]=='1'
				||array1[j]=='2'
				||array1[j]=='3'
				||array1[j]=='4'
				||array1[j]=='5'
				||array1[j]=='6'
				||array1[j]=='7'
				||array1[j]=='8'
				||array1[j]=='9')
				{
					array2[i++]=(int)array1[j];
					j++;
			}
 				else j++;
 		}
 		return array2;
 	}
 	
 	public static void BTree(String[] args)
 	{
 		
		BTree bt= new BTree();
		bt.mid(BTree.createBTree(0));
 	}
	
}