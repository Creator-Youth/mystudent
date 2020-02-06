package wxs0605;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class homeworkWays
{
	
		public static int countFile(File file)
		{
			 int sum=0;
			 if (null == file)
		        {
		            return 0;
		        }
			
			 
	        if (!file.isDirectory())//判断文件是否为目录------file.isDirectory()
	        {
                if(file.getName().endsWith(".java"))
	        	{return 1;}
                else{return 0;}
	        }
	        else
	        {
	        	File[] files = file.listFiles();
	            for (File file1 : files)
	             {
	               sum+=countFile( file1);
	          
	             }
	        }
	        return sum;
		}

		public static int countFileWhitespace(File file) throws IOException
		{
			 int sum=0;
			 if (null == file)
		        {
		            return 0;
		        }
			
			 
	        if (!file.isDirectory())//判断文件是否为目录------file.isDirectory()
	        {

                if(file.getName().endsWith(".java"))
	        	{return countSpacen(file);}
                else{return 0;}
	        }
	        File[] files = file.listFiles();
	        for (File file1 : files)
	        {
	           sum+=countFileWhitespace( file1);
	          
	        }
	        return sum;
		}
		
		public static int countSpace(File file) throws FileNotFoundException
		{
			Scanner sc=new Scanner(file);
			int sum=0;
			while(sc.hasNextLine())
			{
				char a[]=sc.nextLine().toCharArray();
				for(int i=0;i<a.length;i++)
				{
					if((a[i]+"").equals(" ")){sum++;}
					else{}
				}
			}
			sc.close();
			return sum;			
		}
		public static int countSpacen(File file) throws IOException
		{
			FileReader sc=new FileReader (file);
			int sum=0;
			while(sc.read()>0)
			{
				sum++;
			}
			sc.close();
			return sum;			
		}

		public static void fileCreat() throws IOException
		{
			String st1="C:\\tt\\t1\\t2\\a.txt";
			String st2="C:\\tt\\t1\\b.txt";
			String st3="C:\\tt\\t1\\t2\\c.txt";
			String st4="C:\\tt";
			File file=new File("c:\\tt\\t1\\t2");
			file.mkdirs();
			File file1=new File(st1);
			File file2=new File(st2);
			file1.createNewFile();
			file2.createNewFile();
			file2.delete();
			File file3=new File(st3);
			file1.renameTo(file3);
			File file4=new File(st4);
			nameFile(file4);
		}
		
		public static void nameFile(File file)
		{
			if (null == file)
	        {
	            return;
	        }
			if(!file.isDirectory())
			{
				System.out.print("文件-->");
				System.out.println(file.getName());
			}
			else
			{
				System.out.print("目录-->");
				System.out.println(file.getName());
				 File[] files = file.listFiles();
			        for (File file1 : files)
			        {
			           nameFile( file1);
			          
			        }
			}
		}
		
		public static void CopyFile() throws IOException
		{        
		   File inputFile=new File("F:\\java.png");
           File outputFile=new File("F:\\tt\\tt\\java.png"); 
           InputStream inputStream=new FileInputStream(inputFile);
           OutputStream outputStream=new FileOutputStream(outputFile);; 
           byte b[]=new byte[(int)inputFile.length()]; 
           inputStream.read(b);           
           outputStream.write(b);  
           inputStream.close(); 
           outputStream.close();  
          
		}

		

}
