package IO1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
class A implements Serializable
{
    int a1;
    int a2;
  
    A()
    {
        System.out.println("----A-----");
        a1 = 10;
        a2 = 20;
    }
    
    A(int a1, int a2)
    {
        this.a1 = a1;
        this.a2 = a2;
    }
}

@SuppressWarnings("serial")
class B extends A implements Serializable
{
    int b1;
    int b2;
    
    B(int a1, int a2, int b1, int b2)
    {
        super(a1, a2);
        this.b1 = b1;
        this.b2 = b2;
    }
}

class TObject
{

    public static void main(String[] args)
    {
       
        byte[] buf = null;
        try (
                // ����һ��ObjectOutputStream�����
               ByteArrayOutputStream bs = new ByteArrayOutputStream();
               ObjectOutputStream oos = new ObjectOutputStream(bs))
          {
              oos.writeObject(new B(1, 2, 3, 4));
              buf = bs.toByteArray();
          }
          catch (IOException ex)
          {
              ex.printStackTrace();
          }
        
        try (
        // ����һ��ObjectInputStream������
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buf)))
        { 
                    B b = (B) ois.readObject();
                    System.out.println(b.a1 + ", " + b.a2 + ", " + b.b1 + ", " + b.b2);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }  
    }

}
