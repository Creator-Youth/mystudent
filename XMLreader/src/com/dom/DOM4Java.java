package com.dom;
import java.io.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;
public class DOM4Java 
{
   public static void main(String[] args)
   {
	   
	   long lasting = System.currentTimeMillis(); 
		try { 
		  
	String path=DOM4Java.class.getClassLoader().getResource("").toString().substring(6);
		  
		  File f= new File(path+"demo.xml"); 
		  SAXReader reader = new SAXReader(); 
		  
		  Document doc = reader.read(f); 
		  Element root = doc.getRootElement(); //得到根节点
		  for (Iterator i = root.elementIterator("VALUE"); i.hasNext();) 
		  { 
			 Element foo = (Element) i.next(); 
		     Element subfoo=foo.element("NO");
		 System.out.print("车牌号码:" + foo.elementText("NO")+" 属性："
		     +subfoo.attributeValue("DATE")); 
		      System.out.println("车主地址:" + foo.elementText("ADDR")); 
		  }
		  }catch (Exception e)
		    { 
		      e.printStackTrace(); 
		    } 
    System.out.println("运行时间：" + (System.currentTimeMillis() - lasting) + "毫秒");
   }
}
