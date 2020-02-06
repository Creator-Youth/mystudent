package Net;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class net
{ 
    public static void test1()
   {
      try
       {
	      URL url=new URL("http://localhost:8080/StudentManage/enter.html");
	      InputStream in=url.openStream();
	      InputStreamReader is=new InputStreamReader(in,"utf-8");
	      int c=0;
	      while((c=is.read())!=-1)
	      {
	    	  System.out.print((char)c);
	      }
	      in.close();
       }
      catch(Exception e)
      {
    	  e.printStackTrace();
      }
  
   }
}
