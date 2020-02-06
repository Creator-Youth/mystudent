package t20190719;

//Mod4 适配器模式
interface ThreeElectricOutlet{
    public abstract void connectElectricCurrent(); 
}

interface TwoElectricOutlet{
    public abstract void connectElectricCurrent(); 
 } 



class ThreeElectricAdapter implements ThreeElectricOutlet
{
    TwoElectricOutlet outlet;
    ThreeElectricAdapter(TwoElectricOutlet outlet)
    {
     this.outlet=outlet;
    }
    public void connectElectricCurrent(){
        outlet.connectElectricCurrent();
    }
 }


class Wash implements ThreeElectricOutlet{ 
    String name;
    Wash(){
       name="黄河洗衣机";
    }
    Wash(String s){
       name=s;
    }
    public void connectElectricCurrent(){
       turnOn();
    }
    public void turnOn(){
       System.out.println(name+"开始洗衣物。");
    }
}


class TV implements TwoElectricOutlet{  
    String name;
    TV(){
       name="长江电视机";
    }
    TV(String s){
       name=s;
    }
    public void connectElectricCurrent(){
       turnOn();
    }
    public void turnOn(){
       System.out.println(name+"开始播放节目。");
    }
}


public class Mod4
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        ThreeElectricOutlet outlet = null;  
        
        Wash wash = new Wash();            
        outlet = wash;                      
        System.out.println("使用三相插座接通电流：");
        outlet.connectElectricCurrent();   
        
        
        TV tv = new TV();                    
        ThreeElectricAdapter adapter = new ThreeElectricAdapter(tv);
        outlet = adapter;                   
        System.out.println("使用三相插座接通电流：");
        outlet.connectElectricCurrent(); 
    }

}
