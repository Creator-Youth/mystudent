package t20190719;

//抽象工厂

//抽象產品
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

//具体产品
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


//抽象构建者
abstract class ClothesFactory{
    public abstract UpperClothes createUpperClothes(int chestSize,int height);
    public abstract Trousers createTrousers(int waistSize,int height);
}


//具体构建者
class BeijingClothesFactory extends ClothesFactory {
    public UpperClothes createUpperClothes(int chestSize,int height){
         return new WesternUpperClothes("北京牌西服上衣",chestSize,height);
    }
    public Trousers createTrousers(int waistSize,int height){
         return new WesternTrousers("北京牌西服裤子",waistSize,height);
    }
}


class ShanghaiClothesFactory extends ClothesFactory {
    public UpperClothes createUpperClothes(int chestSize,int height){
         return new CowboyUpperClothes("上海牌牛仔上衣",chestSize,height);
    }
    public Trousers createTrousers(int waistSize,int height){
         return new CowboyTrousers("上海牌牛仔裤",waistSize,height);
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
       System.out.println("<套装信息>");
       System.out.println(cloth.getName()+":");
       System.out.print("胸围:"+cloth.getChestSize());
       System.out.println("身高:"+cloth.getHeight());
       System.out.println(trouser.getName()+":");
       System.out.print("腰围:"+trouser.getWaistSize());
       System.out.println("身高:"+trouser.getHeight());
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
