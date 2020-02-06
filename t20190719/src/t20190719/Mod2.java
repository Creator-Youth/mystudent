package t20190719;

//���󹤳�

//����aƷ
abstract class UpperClothes{
    public abstract int getChestSize();
    public abstract int getHeight();
    public abstract String getName(); 
 }

abstract class Trousers{
    public abstract int getWaistSize();
    public abstract int getHeight();
    public abstract String getName(); 
 }

//�����Ʒ
class WesternUpperClothes extends UpperClothes{
    private int chestSize;
    private int height;
    private String name;
    WesternUpperClothes(String name,int chestSize,int height){
        this.name=name;
        this.chestSize=chestSize;
        this.height=height;
    }
    public int getChestSize(){
        return chestSize;
    }
    public int getHeight(){
        return height;
    }
    public String getName(){
        return name;
    } 
 }

class CowboyUpperClothes extends UpperClothes{
    private int chestSize;
    private int height;
    private String name;
    CowboyUpperClothes(String name,int chestSize,int height){
        this.name=name;
        this.chestSize=chestSize;
        this.height=height;
    }
    public int getChestSize(){
        return chestSize;
    }
    public int getHeight(){
        return height;
    }
    public String getName(){
        return name;
    } 
 }


class WesternTrousers extends Trousers{
    private int waistSize;
    private int height;
    private String name;
    WesternTrousers(String name,int waistSize,int height){
        this.name=name;
        this.waistSize=waistSize;
        this.height=height;
    }
     public int getWaistSize(){
        return waistSize;
    }
    public int getHeight(){
        return height;
    }
    public String getName(){
        return name;
    } 
 }

class CowboyTrousers extends Trousers{
    private int waistSize;
    private int height;
    private String name;
    CowboyTrousers(String name,int waistSize,int height){
        this.name=name;
        this.waistSize=waistSize;
        this.height=height;
    }
     public int getWaistSize(){
        return waistSize;
    }
    public int getHeight(){
        return height;
    }
    public String getName(){
        return name;
    } 
 }


//���󹹽���
abstract class ClothesFactory{
    public abstract UpperClothes createUpperClothes(int chestSize,int height);
    public abstract Trousers createTrousers(int waistSize,int height);
}


//���幹����
class BeijingClothesFactory extends ClothesFactory {
    public UpperClothes createUpperClothes(int chestSize,int height){
         return new WesternUpperClothes("��������������",chestSize,height);
    }
    public Trousers createTrousers(int waistSize,int height){
         return new WesternTrousers("��������������",waistSize,height);
    }
}


class ShanghaiClothesFactory extends ClothesFactory {
    public UpperClothes createUpperClothes(int chestSize,int height){
         return new CowboyUpperClothes("�Ϻ���ţ������",chestSize,height);
    }
    public Trousers createTrousers(int waistSize,int height){
         return new CowboyTrousers("�Ϻ���ţ�п�",waistSize,height);
    }
}


class Shop
{
    UpperClothes cloth;
    Trousers trouser; 
    public void giveSuit(ClothesFactory factory,int chestSize,int waistSize,int height)
    {
       cloth = factory.createUpperClothes(chestSize,height);
       trouser = factory.createTrousers(waistSize,height);
       showMess();
    }
    
    private void showMess()
    {
       System.out.println("<��װ��Ϣ>");
       System.out.println(cloth.getName()+":");
       System.out.print("��Χ:"+cloth.getChestSize());
       System.out.println("���:"+cloth.getHeight());
       System.out.println(trouser.getName()+":");
       System.out.print("��Χ:"+trouser.getWaistSize());
       System.out.println("���:"+trouser.getHeight());
    }
}

public class Mod2
{
    public static void main(String[] args)
    {
        Shop shop = new Shop();       
        ClothesFactory factory = new BeijingClothesFactory(); 
        shop.giveSuit(factory,110,82,170);
        
        factory = new ShanghaiClothesFactory(); 
        shop.giveSuit(factory,120,88,180);
    }

}
