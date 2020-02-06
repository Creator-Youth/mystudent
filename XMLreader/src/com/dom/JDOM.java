package com.dom;
import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.*;

public class JDOM {

	public static void main(String[] args) {
	long lasting = System.currentTimeMillis(); 
     try { 
     String path=DOM4Java.class.getClassLoader().getResource("")
    		 .toString().substring(6);
  	 SAXBuilder builder = new SAXBuilder();  
	  Document doc = builder.build(new File(path+"demo.xml"));  
	 Element foo = doc.getRootElement();  
	 List allChildren = foo.getChildren();  
	 for(int i=0;i<allChildren.size();i++) {  
			  //System.out.print("���ƺ���:" + ((Element)allChildren.get(i)).getChild("NO").getAttributeValue("DATE"));
     System.out.print("���ƺ���:" + ((Element)allChildren.get(i)).getChild("NO").getText());
			  System.out.println("������ַ:" + ((Element)allChildren.get(i)).getChild("ADDR").getText());
			}
		} catch (Exception e) { 
			     e.printStackTrace(); 
			}
     System.out.println("����ʱ�䣺" + (System.currentTimeMillis() - lasting) + "����");
	}

}
