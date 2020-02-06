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
                // 创建一个ObjectOutputStream输出流
               ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                  "object4.txt")))
          {
                Person2 per = new Person2("孙悟空", 500);
                oos.writeObject(per);

          }
          catch (IOException ex)
          {
              ex.printStackTrace();
          }
        
        try (
        // 创建一个ObjectInputStream输入流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                "object4.txt")))
        { 
            Person2 p = (Person2) ois.readObject();
            System.out.println("名字为：" + p.getName() + "\n年龄为：" + p.getAge()); 
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }  
    }

}
