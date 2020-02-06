package com.hugeyurt.mvc;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//private URLMapping  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String url=request.getRequestURI();
		 url=url.substring("/MyMVCFrameWork".length(), url.length());
		 System.out.println(url);
        /*
         *  第一步：到beanNameURL进行查找
         */
		 
		   System.out.println(request.getSession().getClass());
		 if(HandleMapping.beanNameMapping.get(url)!=null)
		 {
            String className=HandleMapping.beanNameMapping.get(url);
           try{
            	 Class clz=Class.forName(className);//获得字节码对象
            	 Object object=clz.newInstance();//创建对象
            	if(!(object instanceof MyController))
            		throw new MyMvcException("处理类没有实现MyController接口");
                MyController controller=(MyController)object;
               if(request.getMethod().equals("GET"))
            	   {
            		 controller.doGet(request, response);
            	   }
            	   else
            	   {	
            		   controller.doPost(request, response);
           		      
            	    }
              }catch(Exception e)
              {
            	 e.printStackTrace();  
              }
		 }
		 else
		 {
			 MethodInfo methodInfo=HandleMapping.annotationMethodMapping.get(url);
			 if(methodInfo==null) 
			 {
				 response.setStatus(404);
				 return ;
			 }
			 try{
				Class clz=Class.forName(methodInfo.getClassName());
				Object object=clz.newInstance();
				
				
				List<String> paramClasses=methodInfo.getParams();
				Class paramTypes[]=new Class[methodInfo.getParams().size()];				
				String[] paramNames=new String[paramClasses.size()];
				for(int i=0;i<paramClasses.size();i++)
				{
					String paramName=paramClasses.get(i).split("#")[0];
					String pclassName=paramClasses.get(i).split("#")[1];
					paramTypes[i]=Class.forName(pclassName);
					
					//System.out.println( request.getSession().getClass().getInterfaces()[0]== paramTypes[i] );
					
					paramNames[i]=paramName;
				}
				@SuppressWarnings("unchecked")
				Method method=clz.getDeclaredMethod(methodInfo.getMethodName(), paramTypes);
				Object[] values=RequestDataHandler.handlerRequest(request, response, paramTypes, paramNames);
				Object result=null;
				if(methodInfo.getParams()==null)
			     result=method.invoke(object, null);
				else
				  result=method.invoke(object, values);
				if(methodInfo.getAction().equals("json"))
				{
					PrintWriter out=response.getWriter();
					JSONObject json=null;
					try{
						json=JSONObject.fromObject(result);
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					if(json!=null)
						out.write(json.toString());
					else
					{
						JSONArray json2=JSONArray.fromObject(result);
						out.write(json2.toString());
					}
					
					
					
				}else
				{
				   request.getRequestDispatcher((String)result).forward(request, response);
				}
				 
			 }catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 
		 }
            	            	   	 
            	
             
        
         
	}

  private static Class getType(String pclassName)
  {
	  switch(pclassName)
	  {
	     case "int":  return Integer.TYPE;
	     case "Integer":return Integer.class;
	  }
	  return null;
  }
	
}
