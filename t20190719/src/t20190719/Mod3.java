package t20190719;

import java.util.HashMap;
import java.util.Map;

class DataCenTer
{
	static private DataCenTer da;
	private DataCenTer()
	{
		
	}
	Map<String,String>  ha=new HashMap<String,String>();
	 static public synchronized DataCenTer getDataCenTer()
	 {
		 if(da==null)
		 {
			 da=new DataCenTer();
		 }
		 
		 return da;
	 }
	 
	 public String get(String key)
	 {
		 return ha.get(key);	 
	 }
	 
	 public String Put(String key,String value)
	 {
		 ha.put(key, value);
		 return "成功";		 
	 }
}

//Mod3 单体类
class Moon
{
    static  private  Moon uniqueMoon;  //step 2 static Moon应用   
    
    double              radius;
    double              distanceToEarth;

    //step 1 pirvate
    private Moon()
    {
        radius = 1738;
        distanceToEarth = 363300;
    }

    static public synchronized Moon getMoon() //step3 static getMoon 
    {
        if (uniqueMoon == null)
        {
            uniqueMoon = new Moon();
        }
        return uniqueMoon;
    }

    public String show()
    {
        String s = "月亮的半径是" + radius + "km,距地球是" + distanceToEarth + "km";
        return s;
    }
}

public class Mod3
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        
   
        Moon moon1 = Moon.getMoon();
        System.out.println(moon1.show());
        Moon moon2 = Moon.getMoon();
        System.out.println(moon2.show());
        System.out.println(moon1);
        System.out.println(moon2);
        System.out.println(moon1 == moon2);
        System.out.println("--------------------------------------------------");
        DataCenTer da1=DataCenTer.getDataCenTer();
        System.out.println(da1.get("kk"));
        System.out.println(da1.Put("yy", "33"));
        DataCenTer da2=DataCenTer.getDataCenTer();
        System.out.println(da1);
        System.out.println(da2);
        System.out.println(da1 == da2);
    }

}

