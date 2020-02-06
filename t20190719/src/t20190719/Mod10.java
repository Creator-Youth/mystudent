package t20190719;

//命令者模式

class CompanyArmy//接收者
{
    public void sneakAttack(){ 
       System.out.println("我们知道如何偷袭敌人,保证完成任务"); 
    }
 }

interface Command //接收接口
{
    public abstract void execute();
 }

class ConcreteCommand implements Command
{
    CompanyArmy army;           //含有接收者的引用
    ConcreteCommand(CompanyArmy army)
    {
        this.army = army;
    }
    public  void execute(){    //封装着指挥官的请求
        army.sneakAttack(); // 偷袭敌人
    }
 }

class ArmySuperior{
//    Command command;          //用来存放具体命令的引用
//    public void setCommand(Command command){
//        this.command = command;
//    }
    public void startExecuteCommand(Command command){ 
                       //让具体命令执行execute()方法
        if (null != command)
            command.execute();
    }
  }



public class Mod10
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        CompanyArmy sanlian = new CompanyArmy();
        Command command = new ConcreteCommand(sanlian);
        
        ArmySuperior superior = new ArmySuperior();
        superior.startExecuteCommand(command);
    }

}
