package t20190719;

import java.util.Scanner;

interface Geometry
{
    public double getArea();
} 

class Triangle implements Geometry
{ 
    double sideA,sideB,sideC,area;
    public  Triangle(double a,double b,double c) 
    {
        sideA = a;
        sideB = b;
        sideC = c;
   }
   public double  getArea(){ 
        double p = (sideA + sideB + sideC) / 2.0;
        area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        return area;
  }
} 

class TriangleProxy implements Geometry{ 
    double sideA,sideB,sideC; 
     Triangle triangle;
     
    public  void setABC(double a,double b,double c) 
    {
        sideA = a;
        sideB = b;
        sideC = c;
     }
    
     public double  getArea(){ 
        if (sideA + sideB > sideC && sideA + sideC > sideB
                && sideB + sideC > sideA){
            triangle = new Triangle(sideA, sideB, sideC);
            double area = triangle.getArea();
            return area;
        }
        else {
            return -1;
        }
            
    }
} 

public class Mod8
{
    public static void main(String[] args)
    {
        try(Scanner reader=new Scanner(System.in))
        {
            System.out.println("请输入三个数，每输入一个数回车确认");
            double a = -1, b = -1, c = -1;
            a = reader.nextDouble();
            b = reader.nextDouble();
            c = reader.nextDouble();
            TriangleProxy proxy = new TriangleProxy();
            proxy.setABC(a, b, c);
            double area = proxy.getArea();
            System.out.println("面积是：" + area);
        }
    }
}
