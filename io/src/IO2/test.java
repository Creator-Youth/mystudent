package IO2;

import java.io.*;
public class test
{
    static void wirteStr(String FileName, String strLine, String cs) throws IOException
    {
        File file=new File(FileName);
        file.createNewFile();
        FileOutputStream fi=new  FileOutputStream(FileName);
        OutputStreamWriter writer = new OutputStreamWriter(fi);
        BufferedWriter bf=new BufferedWriter(writer);
        bf.write(strLine);
        bf.newLine();
        bf.write(cs);
        bf.close();
        writer.close();      
    }
    
    static void displayStr(String FileName,String cs) throws IOException
    {
    	 FileInputStream fi=new  FileInputStream(FileName);
    	 InputStreamReader reader = new InputStreamReader(fi, cs);
    	 BufferedReader br = new BufferedReader(reader);
    	 String line = null;
        while ((line = br.readLine()) != null)
        { System.out.println("输入内容为:" + line);}
        br.close();
        reader.close();
    	 
    }
//    
//    public static void main(String[] args)
//    {
////        try (
////                // 将Sytem.in对象转换成Reader对象
////                //InputStreamReader reader = new InputStreamReader(System.in /*, "GBK"*/);
////                //FileReader reader = new FileReader("1.txt");
////                //FileInputStream fin = new FileInputStream("1.txt");
////                //InputStreamReader reader = new InputStreamReader(fin, "utf-8");
////                InputStreamReader reader = new InputStreamReader(
////                        new FileInputStream("1.txt"), "utf-8");
////                // 将普通Reader包装成BufferedReader
////                BufferedReader br = new BufferedReader(reader))
////        {
////            String line = null;
////            // 采用循环方式来一行一行的读取
////            while ((line = br.readLine()) != null)
////            {
////                // 如果读取的字符串为"exit"，程序退出
////                if (line.equals("exit"))
////                {
////                    System.exit(1);
////                }
////                // 打印读取的内容
////                System.out.println("输入内容为:" + line);
////            }
////        }
////        catch (IOException ioe)
////        {
////            ioe.printStackTrace();
////        }
//
//        try (
//                // 将Sytem.in对象转换成Reader对象
//                //OutputStreamWriter writer = new OutputStreamWriter(System.out/*, "GBK"*/);
//                
//                //OutputStreamWriter writer = new OutputStreamWriter(System.out/*, "GBK"*/);
//                
//                //FileWriter writer = new FileWriter("3.txt");
//                
//                OutputStreamWriter writer = new OutputStreamWriter(
//                        new FileOutputStream("4.txt"), "unicode");
//                // 将普通Reader包装成BufferedReader
//                BufferedWriter bw = new BufferedWriter(writer))
//        {
//      
//            bw.write("ab我们一起学习！");
//            bw.newLine();
//            bw.write("ab我们一起玩！");
//            bw.newLine();
//        }
//        catch (IOException ioe)
//        {
//            ioe.printStackTrace();
//        }
//    }
}

