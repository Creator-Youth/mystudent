package BST;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import IO1.Person2;

public class TObject3
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        try (
                // ����һ��ObjectOutputStream�����
               ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                  "object4.txt")))
          {
                Person2 per = new Person2("�����", 500);
                oos.writeObject(per);

          }
          catch (IOException ex)
          {
              ex.printStackTrace();
          }
        
        try (
        // ����һ��ObjectInputStream������
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                "object4.txt")))
        { 
            Person2 p = (Person2) ois.readObject();
            System.out.println("����Ϊ��" + p.getName() + "\n����Ϊ��" + p.getAge()); 
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }  
    }

}
