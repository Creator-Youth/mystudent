package t20190719;

import java.util.ArrayList;

//�н���ģʽ

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
       System.out.println(getName()+"�յ�����Ϣ:");
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
        
        colleagueA.setName("A��");
        colleagueB.setName("B��");
        colleagueC.setName("C��");
        colleagueD.setName("D��");
        
        String[] messA = { "Ҫ��黹�������100������", "Ҫ��黹�������20ͷţ", "1ͷţ" };
        String[] messB = { "Ҫ��黹�������10ֻ����", "Ҫ��黹�������15ƥ��", "2ͷţ" };
        String[] messC = { "Ҫ��黹�������300��С��", "Ҫ��黹�������50ͷ¿", "3ͷţ" };
        String[] messD = { "Ҫ��黹�������100��С��", "Ҫ��黹�������10ͷ¿", "3ͷţ" };
        
        colleagueA.giveMess(messA);            
        colleagueB.giveMess(messB);
        colleagueC.giveMess(messC);   
        colleagueD.giveMess(messD);
    }

}
