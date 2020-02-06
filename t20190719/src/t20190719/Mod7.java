package t20190719;

//装饰模式

abstract class Bird
{
    public abstract int fly();
 }

class Sparrow extends Bird
{
    public final int DISTANCE=100;
    public int fly()
    {
       return DISTANCE;
    }
 }



abstract class Decorator extends Bird{
    protected Bird bird;
    public Decorator()
    {
    }
    public Decorator(Bird bird){
       this.bird=bird; 
    }
}

class  SparrowDecorator extends Decorator{
    public final int DISTANCE=50;        //eleFly方法能飞50米
    SparrowDecorator(Bird bird)
    {
       super(bird);
    }
    
    public int fly()
    {
       int distance=0;
       distance=bird.fly()+eleFly(); 
       return distance; 
    }
    
    private int eleFly()
    {              //装饰者新添加的方法
       return DISTANCE;
    }
 } 


public class Mod7
{
    static public void needBird(Bird bird)
    {
        int flyDistance = bird.fly();
        System.out.println("这只鸟能飞行"+flyDistance +"米");  
    }

    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Bird sparrow = new Sparrow();
        needBird(sparrow);  
        
        Bird sparrowDecorator1 = new SparrowDecorator(sparrow);
        needBird(sparrowDecorator1);
        
        Bird sparrowDecorator2 = new SparrowDecorator(sparrowDecorator1);
        needBird(sparrowDecorator2);   
        
        Bird sparrowDecorator3 = new SparrowDecorator(sparrowDecorator2);
        needBird(sparrowDecorator3); 
    }

}
