package t20190719;

import java.util.ArrayList;

interface Subject
{
    public void addObserver   (Observer o);

    public void deleteObserver(Observer o);

    public void notifyObservers();
}

interface Observer
{
    public void hearTelephone(String heardMess);
}

class SeekJobCenter implements Subject
{
    String              mess;
    boolean             changed;
    ArrayList<Observer> personList;

    SeekJobCenter()
    {
        personList = new ArrayList<Observer>();
        mess = "";
        changed = false;
    }

    public void addObserver(Observer o)
    {
        if (!(personList.contains(o)))
            personList.add(o);
    }

    public void deleteObserver(Observer o)
    {
        if (personList.contains(o))
            personList.remove(o);
    }

    public void notifyObservers()
    {
        if (changed)
        {
            for (int i = 0; i < personList.size(); i++)
            {
                Observer observer = personList.get(i);
                observer.hearTelephone(mess);
            }
            changed = false;
        }
    }

    public void giveNewMess(String str)
    {
        if (str.equals(mess))
            changed = false;
        else
        {
            mess = str;
            changed = true;
        }
    }
}


class UniverStudent implements Observer
{
    Subject subject;

    UniverStudent(Subject subject)
    {
        this.subject = subject;
        subject.addObserver(this); // 使当前实例成为subject所引用的具体主题的观察者
    }

    public void hearTelephone(String heardMess)
    {
        // 更新文件中的内容
        System.out.println("我是一个大学生, 收到职位信息: " + heardMess);
    }
}

class HaiGui implements Observer
{
    Subject subject;

    HaiGui(Subject subject)
    {
        this.subject = subject;
        subject.addObserver(this); // 使当前实例成为subject所引用的具体主题的观察者
    }

    public void hearTelephone(String heardMess)
    {
        boolean boo = heardMess.contains("java程序员") || heardMess.contains("软件");
        if (boo)
        {
            System.out.println("我是一个海归, 收到职位信息: " + heardMess);
        }
        else
        {
            System.out.println("我是一个海归, 我不关心: " + heardMess);
        }
    }
}



public class Mod12
{

    @SuppressWarnings("unused")
	public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        SeekJobCenter center = new SeekJobCenter();
        UniverStudent zhangLin = new UniverStudent(center);
        HaiGui wangHao = new HaiGui(center);
        
        center.giveNewMess("腾辉公司需要10个java程序员。");
        center.notifyObservers();
        
        center.giveNewMess("海景公司需要8个动画设计师。");
        center.notifyObservers();
        
        
        center.giveNewMess("仁海公司需要9个电工。");
        center.notifyObservers();
        
        center.giveNewMess("仁海公司需要9个电工。");
        center.notifyObservers();         
    }

}

