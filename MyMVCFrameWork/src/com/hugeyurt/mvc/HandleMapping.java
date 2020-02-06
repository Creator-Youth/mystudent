package com.hugeyurt.mvc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;


public final class HandleMapping
{
  private HandleMapping(){}
     
 public static HashMap<String,String> beanNameMapping
      =new HashMap<String,String>();
 public static HashMap<String,MethodInfo> annotationMethodMapping
    =new HashMap<String,MethodInfo>();
 
 static {
	 try { 
	     String path=HandleMapping.class.getClassLoader().getResource("")
	    		 .toString().substring(6);
	  	 SAXBuilder builder = new SAXBuilder();  
		  Document doc = builder.build(new File(path+"config/urlmappings.xml"));  
		 Element foo = doc.getRootElement();
		 List allChildren = foo.getChildren();  
		 for(int i=0;i<allChildren.size();i++) 
		  {  
			 Element  element=(Element)allChildren.get(i);
			 if(element.getAttribute("url")!=null)
			 {
				 String key=element.getAttribute("url").getValue();
				 String className=element.getAttribute("class").getValue();
				// String action=element.getAttributeValue("action");
				 HandleMapping.beanNameMapping.put(key, className);
			 }
			 else
			 {
				 String className=element.getAttribute("class").getValue();
				 List methodChildren=element.getChildren();
				 for(int j=0;j<methodChildren.size();j++)
				 {
					 Element  child=(Element)methodChildren.get(j);
					 String url=child.getAttributeValue("url");
					 String methodName=child.getAttributeValue("name");
					 String action=child.getAttributeValue("action");
					  List  params=child.getChildren();
					  List<String> paramsList=new ArrayList<String>();
					   for(int k=0;k<params.size();k++)
					   {
					       Element  subChild=(Element)params.get(k);
					       String paramName=subChild.getAttributeValue("name");
					       String paramClass=subChild.getText();
					      paramsList.add(paramName+"#"+paramClass);
					   }
					  MethodInfo methodInfo=new MethodInfo();
					  methodInfo.setUrl(url);
					  methodInfo.setClassName(className);
					  methodInfo.setMethodName(methodName);
					  methodInfo.setParams(paramsList);
					  methodInfo.setAction(action);
					  HandleMapping.annotationMethodMapping.put(url, methodInfo);
				 }
			 }
		
		  }
			} catch (Exception e) { 
				     e.printStackTrace(); 
				} 
	 
 }
    
     
}
