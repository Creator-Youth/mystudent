package com.dom;

import org.xml.sax.*;  
import org.xml.sax.helpers.*;  
import javax.xml.parsers.*;  
  
class MyXMLReader extends DefaultHandler 
 {  
  
   java.util.Stack tags = new java.util.Stack();   
    public MyXMLReader() 
    {   
      super();  
    }  
  public void startElement(String uri,String localName,String qName,Attributes attrs)
  {   
     tags.push(qName);
   }  
  public void characters(char ch[], int start, int length) throws SAXException
  {   
	  String tag = (String) tags.peek();   
	  if (tag.equals("NO")) 
	  {    
	    System.out.print("���ƺ��룺" + new String(ch, start, length));  
	   }  
	  if (tag.equals("ADDR"))
	  {
		  
	  	    System.out.println("��ַ:" + new String(ch, start, length));  
	   }  
  }

}
 
public class XMLJdom {
	
		public static void main(String args[])
		{
			long lasting = System.currentTimeMillis();
			try {
				SAXParserFactory sf = SAXParserFactory.newInstance();
				SAXParser sp = sf.newSAXParser();
				MyXMLReader reader = new MyXMLReader();
				sp.parse(new InputSource("d:\\kk\\demo.xml"), reader);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("����ʱ�䣺" + (System.currentTimeMillis() - lasting) + "����");
		}
	
 }

