package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		
        	try
        	{
				ServerSocket service=new ServerSocket(12345);
				Socket serv=service.accept();
				
				InputStream is =serv.getInputStream();
				OutputStream os=serv.getOutputStream();
				
				os.write("hello".getBytes());

				
				byte[] getmsg=new byte[100];
				int len=is.read(getmsg);
				System.out.println(new String(getmsg,0,len));
				
				Scanner scanner=new Scanner (System.in);
				String sendmsg=null;
				while(true)
				{
					sendmsg=scanner.next();
					if(sendmsg.equals("bye"))
						break;
					os.write(sendmsg.getBytes());
					os.flush();
					
					len=is.read(getmsg);
					System.out.println(new String(getmsg,0,len));
					if(getmsg.equals("bye"))
						break;
				}

				
				System.out.print("service close");
				service.close();
				
			} catch (IOException e) 
        	{
			
				e.printStackTrace();
			}
        	
        
	}

}
