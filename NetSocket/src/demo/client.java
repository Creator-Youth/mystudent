package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
        try
        {
			Socket client=new Socket("192.168.1.76",8999);
			
			InputStream  is=client.getInputStream();
			OutputStream os=client.getOutputStream();
			
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
			System.out.println("client close");
			client.close();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}

