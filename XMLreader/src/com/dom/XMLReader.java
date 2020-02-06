package com.dom;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class XMLReader {
	
	public static void dom()
	{
	long lasting =System.currentTimeMillis(); //获取当前毫秒数
	try{ 
		   String path=XMLReader.class.getClassLoader().getResource("").toString();
		   System.out.println(path);
		   int m=path.indexOf("/");
		   path=path.substring(m+1)+"demo.xml";
		   System.out.println(path);
		   File f=new File(path); 
		   DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance(); 
	       DocumentBuilder builder=factory.newDocumentBuilder(); 
		   Document doc = builder.parse(f); 
		NodeList nl = doc.getElementsByTagName("VALUE"); 
		for (int i=0;i<nl.getLength();i++)
		{ 
	      System.out.print("车牌号码:" + doc.getElementsByTagName("NO").item(i).getFirstChild().getNodeValue()); 
		  System.out.println("车主地址:" + doc.getElementsByTagName("ADDR").item(i).getFirstChild().getNodeValue()); 
	     } 
		}catch(Exception e)
	    { 
		   //e.printStackTrace();
		}
	  System.out.println("运行时间：" + (System.currentTimeMillis() - lasting) + "毫秒");
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                dom();
	}

}
