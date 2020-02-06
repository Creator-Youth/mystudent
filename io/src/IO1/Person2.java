package IO1;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings({ "serial", "unused" })
public class Person2 implements Serializable
{
    private String name;
    private int    age;

    public Person2(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return this.age;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException
    {
    	System.out.println("----->writeObject");
        // ��nameʵ��������ֵ��ת��д���������
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age - 100);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        // ����ȡ���ַ�����ת�󸳸�nameʵ������
    	System.out.println("----->readObject");
        this.name = ((StringBuffer) in.readObject()).reverse().toString();
        this.age = in.readInt() + 100;
    }
    
    //  ��дwriteReplace���������������л��ö���֮ǰ���ȵ��ø÷���
//    private Object writeReplace()throws ObjectStreamException
//    {
//        ArrayList<Object> list = new ArrayList<>();
//        System.out.println("----->writeReplace");
//        list.add(name);
//        list.add(age);
//        return list;
//    }
//    
//    private Object readResolve() throws ObjectStreamException
//    {
//    	 System.out.println("----->readResolve");
//        ArrayList<Object> list = new ArrayList<>();
//        list.add(name);
//        list.add(age);
//        return list;
//    }
}