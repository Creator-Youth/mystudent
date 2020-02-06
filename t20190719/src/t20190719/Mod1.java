package t20190719;
//Mod1 �������� 
//�����Ʒ
abstract class PenCore
{
    String color;
    public abstract void writeWord(String s);
 }

//�����Ʒ
class RedPenCore extends PenCore
{
    RedPenCore()
    {
      color="��ɫ";
    }
    public void writeWord(String s)
    {
        System.out.println("д��"+color+"����:"+s);
     }
 }

class BluePenCore extends PenCore
{
    BluePenCore(){
      color="��ɫ";
    }
    public void writeWord(String s){
       System.out.println("д��"+color+"����:"+s);
    }
}

class BlackPenCore extends PenCore
{
    BlackPenCore(){
      color="��ɫ";
    }
    public void writeWord(String s){
       System.out.println("д��"+color+"����:"+s);
    }
}

class YellowPencore extends PenCore
{
	YellowPencore()
	{
		color="��ɫ";
	}
	public void writeWord(String s)
	{
		System.out.println("д��"+color+"����:"+s);
	}
}


//���󹹽���
abstract class BallPen
{
    BallPen()
    {
       System.out.println("������һֻװ��"+getPenCore().color+"��о��Բ���");
    }
    public abstract PenCore getPenCore(); //��������
}


//���幹����
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
        PenCore penCore = null; //����P
        BallPen ballPen = new BlueBallPen(); //���󹹽���
        penCore = ballPen.getPenCore();
        penCore.writeWord("���,�ܸ�����ʶ��");

        ballPen = new RedBallPen();
        penCore = ballPen.getPenCore();
        penCore.writeWord("How are you");

        ballPen = new BlackBallPen();
        penCore = ballPen.getPenCore();
        penCore.writeWord("nice to meet you");
        
        ballPen = new YellowBallPen();
        penCore = ballPen.getPenCore();
        penCore.writeWord("����Ц����");

    }

}