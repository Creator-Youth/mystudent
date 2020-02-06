package t20190719;
//Mod1 工厂方法 
//抽象产品
abstract class PenCore
{
    String color;
    public abstract void writeWord(String s);
 }

//具体产品
class RedPenCore extends PenCore
{
    RedPenCore()
    {
      color="红色";
    }
    public void writeWord(String s)
    {
        System.out.println("写出"+color+"的字:"+s);
     }
 }

class BluePenCore extends PenCore
{
    BluePenCore(){
      color="蓝色";
    }
    public void writeWord(String s){
       System.out.println("写出"+color+"的字:"+s);
    }
}

class BlackPenCore extends PenCore
{
    BlackPenCore(){
      color="黑色";
    }
    public void writeWord(String s){
       System.out.println("写出"+color+"的字:"+s);
    }
}

class YellowPencore extends PenCore
{
	YellowPencore()
	{
		color="黄色";
	}
	public void writeWord(String s)
	{
		System.out.println("写出"+color+"的字:"+s);
	}
}


//抽象构建者
abstract class BallPen
{
    BallPen()
    {
       System.out.println("生产了一只装有"+getPenCore().color+"笔芯的圆珠笔");
    }
    public abstract PenCore getPenCore(); //工厂方法
}


//具体构建者
class RedBallPen extends BallPen
{
    public PenCore getPenCore()
    {
       return new RedPenCore();
    }
}

class BlueBallPen extends BallPen{
    public PenCore getPenCore(){
       return new BluePenCore();
    }
}

class BlackBallPen extends BallPen{
    public PenCore getPenCore(){
       return new BlackPenCore();
    }
}

class YellowBallPen extends BallPen
{
	public PenCore getPenCore()
	{
		return new YellowPencore();
	}

}


public class Mod1
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        PenCore penCore = null; //抽象筆
        BallPen ballPen = new BlueBallPen(); //抽象构建者
        penCore = ballPen.getPenCore();
        penCore.writeWord("你好,很高兴认识你");

        ballPen = new RedBallPen();
        penCore = ballPen.getPenCore();
        penCore.writeWord("How are you");

        ballPen = new BlackBallPen();
        penCore = ballPen.getPenCore();
        penCore.writeWord("nice to meet you");
        
        ballPen = new YellowBallPen();
        penCore = ballPen.getPenCore();
        penCore.writeWord("表面笑嘻嘻");

    }

}