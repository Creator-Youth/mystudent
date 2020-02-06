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
        subject.addObserver(this); // ʹ��ǰʵ����Ϊsubject�����õľ�������Ĺ۲���
    }

    public void hearTelephone(String heardMess)
    {
        // �����ļ��е�����
        System.out.println("����һ����ѧ��, �յ�ְλ��Ϣ: " + heardMess);
    }
}

class HaiGui implements Observer
{
    Subject subject;

    HaiGui(Subject subject)
    {
        this.subject = subject;
        subject.addObserver(this); // ʹ��ǰʵ����Ϊsubject�����õľ�������Ĺ۲���
    }

    public void hearTelephone(String heardMess)
    {
        boolean boo = heardMess.contains("java����Ա") || heardMess.contains("���");
        if (boo)
        {
            System.out.println("����һ������, �յ�ְλ��Ϣ: " + heardMess);
        }
        else
        {
            System.out.println("����һ������, �Ҳ�����: " + heardMess);
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
        
        center.giveNewMess("�ڻԹ�˾��Ҫ10��java����Ա��");
        center.notifyObservers();
        
        center.giveNewMess("������˾��Ҫ8���������ʦ��");
        center.notifyObservers();
        
        
        center.giveNewMess("�ʺ���˾��Ҫ9���繤��");
        center.notifyObservers();
        
        center.giveNewMess("�ʺ���˾��Ҫ9���繤��");
        center.notifyObservers();         
    }

}

