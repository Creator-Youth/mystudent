package IO1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Write 
{

	public static void main(String[] args) 
	{
		try
		(ObjectOutputStream ob=new ObjectOutputStream(new FileOutputStream("dd.txt")))
		{
			student st=new student("wangxianshou",21);
			ob.writeObject(st);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
