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
			  //System.out.print("车牌号码:" + ((Element)allChildren.get(i)).getChild("NO").getAttributeValue("DATE"));
     System.out.print("车牌号码:" + ((Element)allChildren.get(i)).getChild("NO").getText());
			  System.out.println("车主地址:" + ((Element)allChildren.get(i)).getChild("ADDR").getText());
			}
		} catch (Exception e) { 
			     e.printStackTrace(); 
			}
     System.out.println("运行时间：" + (System.currentTimeMillis() - lasting) + "毫秒");
	}

}
