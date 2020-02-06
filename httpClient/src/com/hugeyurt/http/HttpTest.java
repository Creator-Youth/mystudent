package com.hugeyurt.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpTest {
	
	public static void getMethod(String testUrl) throws Exception {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpGet = new HttpGet(testUrl);
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try {
				System.out.println(response.getStatusLine());
				HttpEntity entity = response.getEntity();
				System.out.println(EntityUtils.toString(entity));
			
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}
	
	public static void postMethod(String testUrl) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost(testUrl);
		    StringEntity ent = new StringEntity("{\"stuid\":\"te0001\",\"pwd\":\"123\"}");
	    	httpPost.setEntity(ent);
		    CloseableHttpResponse response = httpclient.execute(httpPost);
		   try {
			    System.out.println(response.getStatusLine());
		        HttpEntity entity = response.getEntity();
		        System.out.println(EntityUtils.toString(entity));
		     } finally {
		       response.close();
		    }
		} finally {
			httpclient.close();
		}   
		}

    public static void post2(String url,String user,String pwd)
    {
    	try{
    	 Content con=Request.Post(url).bodyForm(
    			Form.form().add("stuid", user).add("pwd", pwd).build()).execute().returnContent();
    	System.out.println(con.toString());
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
	
    public static String get(String url)
    {
    	try{
    	 Content con=Request.Get(url).execute().returnContent();
    	 return con.toString();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return "";
    }
	
    public static String postTwo(String url)
    {
    	try{
    	 Content con=Request.Post(url).execute().returnContent();
    	 return con.toString();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return "";
    }
    
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
      //getMethod("http://www.njupt.edu.cn");
	  // System.out.println(get("http://192.168.1.21:8080/EPointMVC/view.qf?page=1&count=10"));
    // postMethod("http://192.168.1.5:8080/webStudentManager/login.do");
	 /*for(int i=0;i<20000;i++)
	  {
		Thread thread= new Thread(new Runnable() {
			public void run() {
				
				post2("http://192.168.1.5:8080/webStudentManager/login.do","te0001","123");
			}
		});
	  thread.start();
	  }	*/
		
        System.out.println(get("http://192.168.1.51:8080/Student/teaQueryStu.do"));
	}

}
