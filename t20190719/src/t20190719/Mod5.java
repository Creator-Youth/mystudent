package t20190719;


//桥接模式
abstract class  ArchitectureCost             //抽象
{
    BuildingDesign  design;
    double unitPrice;
    public  abstract double giveCost() ;
} 

interface BuildingDesign                     //细化抽象
{
    public double computerArea();  
} 

class  BuildingCost extends ArchitectureCost //实现者
{
    BuildingCost(BuildingDesign design,double unitPrice)
    {
           this.design=design;
           this.unitPrice=unitPrice*(1);
    }
    public  double giveCost() {
          double area=design.computerArea();
          return area*unitPrice;
    }
}

class HouseDesign implements BuildingDesign  //具体实现者
{
    double width,length;
    int floorNumber;
    HouseDesign(double width,double length,int floorNumber){
          this.width=width;
          this.length=length;
          this.floorNumber=floorNumber;
    }
    public double computerArea(){
          return width*length*floorNumber;
    }
} 



public class Mod5
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        double width = 63, height = 30;
        int floorNumber = 8;
        double unitPrice = 6867.38;
        BuildingDesign design = new HouseDesign(width, height, floorNumber);
        System.out
                .println("宽" + width + "米，高" + height + "米，层数为" + floorNumber);

        ArchitectureCost cost = new BuildingCost(design, unitPrice);
        double price = cost.giveCost();
        System.out.printf("每平米造价：" + unitPrice + "元的商业楼的建设成本：%.2f元\n", price);
        
        
        width = 52;
        height = 28;
        floorNumber = 6;
        unitPrice = 2687.88;
        design = new HouseDesign(width, height, floorNumber);
        System.out
                .println("宽" + width + "米，高" + height + "米，层数为" + floorNumber);
        cost = new BuildingCost(design, unitPrice);
        price = cost.giveCost();
        System.out.printf("每平米造价：" + unitPrice + "元的住宅楼的建设成本：%.2f元\n", price);


    }

}
