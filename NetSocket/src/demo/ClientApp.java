package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Socket socket = new Socket("192.168.1.113", 9080);
			InputStream is = socket.getInputStream();
			
			byte[] buff = new byte[1024];
			int len = -1;
			
			SendThread st = new SendThread(socket);
			Thread t = new Thread(st);
			t.start();
			while(true)
			{
				len = is.read(buff);
				String str = new String(buff, 0, len);
				System.out.println("收到来自另一客户端的消息--->" + str);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class SendThread implements Runnable{
	private Socket socket;
	
	public SendThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in)) 
		{
			OutputStream os = socket.getOutputStream();
			while(true)
			{
				System.out.print("input--->");
				String s = sc.nextLine();
				os.write(s.getBytes());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
