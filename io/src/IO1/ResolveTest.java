package IO1;

import java.io.*;
import java.util.ArrayList;

public class ResolveTest
{
    @SuppressWarnings("rawtypes")
	public static void main(String[] args)
    {
        try (
        // ����һ��ObjectOutputStream������
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                "transient.txt"));
        // ����һ��ObjectInputStream������
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("transient.txt")))
        {
            Person2 per = new Person2("�����", 500);
            // ϵͳ��per����ת���ֽ����в����
            oos.writeObject(per);
            
            // �����л���ȡ�õ�����ArrayList
            ArrayList list = (ArrayList)ois.readObject();
            System.out.println(list);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}