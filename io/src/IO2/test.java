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
        { System.out.println("��������Ϊ:" + line);}
        br.close();
        reader.close();
    	 
    }
//    
//    public static void main(String[] args)
//    {
////        try (
////                // ��Sytem.in����ת����Reader����
////                //InputStreamReader reader = new InputStreamReader(System.in /*, "GBK"*/);
////                //FileReader reader = new FileReader("1.txt");
////                //FileInputStream fin = new FileInputStream("1.txt");
////                //InputStreamReader reader = new InputStreamReader(fin, "utf-8");
////                InputStreamReader reader = new InputStreamReader(
////                        new FileInputStream("1.txt"), "utf-8");
////                // ����ͨReader��װ��BufferedReader
////                BufferedReader br = new BufferedReader(reader))
////        {
////            String line = null;
////            // ����ѭ����ʽ��һ��һ�еĶ�ȡ
////            while ((line = br.readLine()) != null)
////            {
////                // �����ȡ���ַ���Ϊ"exit"�������˳�
////                if (line.equals("exit"))
////                {
////                    System.exit(1);
////                }
////                // ��ӡ��ȡ������
////                System.out.println("��������Ϊ:" + line);
////            }
////        }
////        catch (IOException ioe)
////        {
////            ioe.printStackTrace();
////        }
//
//        try (
//                // ��Sytem.in����ת����Reader����
//                //OutputStreamWriter writer = new OutputStreamWriter(System.out/*, "GBK"*/);
//                
//                //OutputStreamWriter writer = new OutputStreamWriter(System.out/*, "GBK"*/);
//                
//                //FileWriter writer = new FileWriter("3.txt");
//                
//                OutputStreamWriter writer = new OutputStreamWriter(
//                        new FileOutputStream("4.txt"), "unicode");
//                // ����ͨReader��װ��BufferedReader
//                BufferedWriter bw = new BufferedWriter(writer))
//        {
//      
//            bw.write("ab����һ��ѧϰ��");
//            bw.newLine();
//            bw.write("ab����һ���棡");
//            bw.newLine();
//        }
//        catch (IOException ioe)
//        {
//            ioe.printStackTrace();
//        }
//    }
}
