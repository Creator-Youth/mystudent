package t20190719;

//������ģʽ

class CompanyArmy//������
{
    public void sneakAttack(){ 
       System.out.println("����֪�����͵Ϯ����,��֤�������"); 
    }
 }

interface Command //���սӿ�
{
    public abstract void execute();
 }

class ConcreteCommand implements Command
{
    CompanyArmy army;           //���н����ߵ�����
    ConcreteCommand(CompanyArmy army)
    {
        this.army = army;
    }
    public  void execute(){    //��װ��ָ�ӹٵ�����
        army.sneakAttack(); // ͵Ϯ����
    }
 }

class ArmySuperior{
//    Command command;          //������ž������������
//    public void setCommand(Command command){
//        this.command = command;
//    }
    public void startExecuteCommand(Command command){ 
                       //�þ�������ִ��execute()����
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
