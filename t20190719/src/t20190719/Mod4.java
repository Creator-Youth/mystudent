package t20190719;

//Mod4 ������ģʽ
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
       name="�ƺ�ϴ�»�";
    }
    Wash(String s){
       name=s;
    }
    public void connectElectricCurrent(){
       turnOn();
    }
    public void turnOn(){
       System.out.println(name+"��ʼϴ���");
    }
}


class TV implements TwoElectricOutlet{  
    String name;
    TV(){
       name="�������ӻ�";
    }
    TV(String s){
       name=s;
    }
    public void connectElectricCurrent(){
       turnOn();
    }
    public void turnOn(){
       System.out.println(name+"��ʼ���Ž�Ŀ��");
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
        System.out.println("ʹ�����������ͨ������");
        outlet.connectElectricCurrent();   
        
        
        TV tv = new TV();                    
        ThreeElectricAdapter adapter = new ThreeElectricAdapter(tv);
        outlet = adapter;                   
        System.out.println("ʹ�����������ͨ������");
        outlet.connectElectricCurrent(); 
    }

}
