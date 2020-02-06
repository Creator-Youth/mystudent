package t20190719;


//�Ž�ģʽ
abstract class  ArchitectureCost             //����
{
    BuildingDesign  design;
    double unitPrice;
    public  abstract double giveCost() ;
} 

interface BuildingDesign                     //ϸ������
{
    public double computerArea();  
} 

class  BuildingCost extends ArchitectureCost //ʵ����
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

class HouseDesign implements BuildingDesign  //����ʵ����
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
                .println("��" + width + "�ף���" + height + "�ף�����Ϊ" + floorNumber);

        ArchitectureCost cost = new BuildingCost(design, unitPrice);
        double price = cost.giveCost();
        System.out.printf("ÿƽ����ۣ�" + unitPrice + "Ԫ����ҵ¥�Ľ���ɱ���%.2fԪ\n", price);
        
        
        width = 52;
        height = 28;
        floorNumber = 6;
        unitPrice = 2687.88;
        design = new HouseDesign(width, height, floorNumber);
        System.out
                .println("��" + width + "�ף���" + height + "�ף�����Ϊ" + floorNumber);
        cost = new BuildingCost(design, unitPrice);
        price = cost.giveCost();
        System.out.printf("ÿƽ����ۣ�" + unitPrice + "Ԫ��סլ¥�Ľ���ɱ���%.2fԪ\n", price);


    }

}
