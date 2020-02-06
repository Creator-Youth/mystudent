package t20190719;

import java.util.ArrayList;

//中介者模式

abstract class Colleague{
    protected ConcreteMediator mediator; 
    private String name;

    Colleague(ConcreteMediator mediator){
        this.mediator = mediator;
        mediator.registerColleague(this);
     }
    
    public void setName(String name){
        this.name=name;
     }
     
     public String getName(){
         return name;
     } 
     
     abstract public void giveMess(String [] mess);
     abstract public void receiverMess(String mess);
}

class ConcreteMediator{
    ArrayList<Colleague> colleagueList = new ArrayList<Colleague>();

    public void registerColleague(Colleague colleague){
        colleagueList.add(colleague);
    }  
    
    public void deliverMess(Colleague colleague, String [] mess){
        if (mess.length < colleagueList.size() - 1){
            return;
        }

        int i = 0;
        for (Colleague item : colleagueList)
        {
            if (item != colleague)
            {
                item.receiverMess(colleague.getName() + mess[i++]);
            }
        } 
    }
}

class ConcreteColleague extends Colleague{
   
    ConcreteColleague(ConcreteMediator mediator){
        super(mediator);
        
    }
    
    public void giveMess(String [] mess){
        mediator.deliverMess(this, mess);
    }
    
    public void receiverMess(String mess){
       System.out.println(getName()+"收到的信息:");
       System.out.println("\t"+mess);
    }
}




public class Mod11
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleague colleagueA = new ConcreteColleague(mediator);
        ConcreteColleague colleagueB = new ConcreteColleague(mediator);
        ConcreteColleague colleagueC = new ConcreteColleague(mediator);
        ConcreteColleague colleagueD = new ConcreteColleague(mediator);
        
        colleagueA.setName("A国");
        colleagueB.setName("B国");
        colleagueC.setName("C国");
        colleagueD.setName("D国");
        
        String[] messA = { "要求归还曾抢夺的100斤土豆", "要求归还曾抢夺的20头牛", "1头牛" };
        String[] messB = { "要求归还曾抢夺的10只公鸡", "要求归还曾抢夺的15匹马", "2头牛" };
        String[] messC = { "要求归还曾抢夺的300斤小麦", "要求归还曾抢夺的50头驴", "3头牛" };
        String[] messD = { "要求归还曾抢夺的100斤小麦", "要求归还曾抢夺的10头驴", "3头牛" };
        
        colleagueA.giveMess(messA);            
        colleagueB.giveMess(messB);
        colleagueC.giveMess(messC);   
        colleagueD.giveMess(messD);
    }

}
