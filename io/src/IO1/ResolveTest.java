package IO1;

import java.io.*;
import java.util.ArrayList;

public class ResolveTest
{
    @SuppressWarnings("rawtypes")
	public static void main(String[] args)
    {
        try (
        // 创建一个ObjectOutputStream输入流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                "transient.txt"));
        // 创建一个ObjectInputStream输入流
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("transient.txt")))
        {
            Person2 per = new Person2("孙悟空", 500);
            // 系统将per对象转换字节序列并输出
            oos.writeObject(per);
            
            // 反序列化读取得到的是ArrayList
            ArrayList list = (ArrayList)ois.readObject();
            System.out.println(list);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
