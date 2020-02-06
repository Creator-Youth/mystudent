package t20190719;

import java.util.ArrayList;

//责任链模式 
abstract class Handler{
    protected Handler handler;  
    
    public void setNextHandler(Handler handler){
        this.handler = handler;
    }
    
    public abstract void handleRequest(String number);
 }

class Beijing extends Handler{
     
    private ArrayList<String> numberList; 
    Beijing()
    {
       numberList=new ArrayList<String>();
       numberList.add("11129812340930034"); 
       numberList.add("10120810340930632");
       numberList.add("22029812340930034"); 
       numberList.add("32620810340930632");
    }
    public void handleRequest(String number)
    {
        if (numberList.contains(number))
            System.out.println("该人在北京居住");
        else{
            System.out.println("该人不在北京居住");
            if (handler != null)
                handler.handleRequest(number);  
       }
    }

}


class Shanghai extends Handler{            
    private ArrayList<String> numberList; 
    Shanghai(){
       numberList=new ArrayList<String>();
       numberList.add("34529812340930034"); 
       numberList.add("98720810340430632");
       numberList.add("36529812340930034"); 
       numberList.add("77720810340930632");
    }
    public void handleRequest(String number){
       if(numberList.contains(number))
          System.out.println("该人在上海居住");
       else{
          System.out.println("该人不在上海居住");
          if(handler!=null)
             handler.handleRequest(number);     
       }
    }
}

class Tianjin extends Handler{             
    private ArrayList<String> numberList;  
    Tianjin(){
       numberList=new ArrayList<String>();
       numberList.add("10029812340930034"); 
       numberList.add("20020810340430632");
       numberList.add("30029812340930034"); 
       numberList.add("50020810340930632");
    }
    public void handleRequest(String number){
       if(numberList.contains(number))
          System.out.println("该人在天津居住");
       else{
          System.out.println("该人不在天津居住");
          if(handler!=null)
             handler.handleRequest(number);      
       }
    }
}



public class Mod9
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Handler beijing = new Beijing();
        Handler shanghai = new Shanghai();
        Handler tianjin = new Tianjin();
        
        beijing.setNextHandler(shanghai);
        shanghai.setNextHandler(tianjin);
        System.out.println("111111111");
        beijing.handleRequest("36529812340930034");

    }

}
