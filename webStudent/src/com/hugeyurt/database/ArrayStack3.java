package com.hugeyurt.database;

public class ArrayStack3<T>  //type
{
	private T data[];
	private int top;
	
	@SuppressWarnings("unchecked")
	public ArrayStack3()
	{
		this.data=(T[])new Object[10];
		this.top=-1;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack3(int size)
	{
		this.data=(T[])new Object[size];
		this.top=-1;
	}
	
   public boolean push(T num)
   {
	   if(this.top+1==this.data.length) return false;
	   this.top++;
	   this.data[this.top]=num;
	   return true;
   }
   
   public T pop()
   {
	   if(this.top==-1) return null;
	   return this.data[this.top--];
   }
   
   public boolean  isEmpty()
   {
	   return this.top==-1;
   }

   public boolean isFull()
   {
	   return this.top==this.data.length-1;
   }
}
