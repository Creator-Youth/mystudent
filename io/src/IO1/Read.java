package IO1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Read 
{

	public static void main(String[] args) throws ClassNotFoundException
	{

    try( ObjectInputStream ob=new ObjectInputStream(new FileInputStream("dd.txt")))
    {
    	 student pe=(student) ob.readObject();
    	 System.out.println(pe.getName());
    	 
    }
    catch(IOException e)
    {
    	e.printStackTrace();
    }

	}

}
