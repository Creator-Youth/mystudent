package t20190719;

import java.util.Iterator;
import java.util.LinkedList;

interface MilitaryPerson{
    public void add(MilitaryPerson person) ;
    public void remove(MilitaryPerson person) ;
    public MilitaryPerson getChild(int index); 
    public Iterator<MilitaryPerson>  getAllChildren() ;
    public boolean isLeaf();
    public double getSalary();
    public void setSalary(double salary);
} 


class MilitaryOfficer implements MilitaryPerson{
    LinkedList<MilitaryPerson> list;
    String name;
    double salary;
    MilitaryOfficer(String name,double salary){
          this.name=name;
          this.salary=salary;
          list = new LinkedList<MilitaryPerson>();
    } 
    public void add(MilitaryPerson person) {
          list.add(person);
    }
    public void remove(MilitaryPerson person){
          list.remove(person);
    }
    public MilitaryPerson getChild(int index) {
          return list.get(index); 
    }
    public Iterator<MilitaryPerson>  getAllChildren() {
          return list.iterator(); 
    }
    public boolean isLeaf(){
         return false;
    } 
    public double getSalary(){
          return salary;
    }
    public void setSalary(double salary){
         this.salary = salary;
    }
}


class MilitarySoldier implements MilitaryPerson{
    double salary;
    String name;
    MilitarySoldier(String name,double salary){
          this.name=name;
          this.salary=salary;
    }
    
    public void add(MilitaryPerson person)  {}
    public void remove (MilitaryPerson person){}
    public MilitaryPerson getChild(int index) {
         return null;
    } 
    public Iterator<MilitaryPerson>  getAllChildren() {
         return null;
    }
    
    
     public boolean isLeaf(){
         return true;
    } 
    public double getSalary(){
         return salary;
    }
    public void setSalary(double salary){
         this.salary=salary;
    }
}

class ComputerSalary
{
    public static double computerSalary(MilitaryPerson person)
    {
        double sum = 0;
        if (person.isLeaf())
        {
            sum = sum + person.getSalary();
        }
        else
        {
            sum = sum + person.getSalary();
            Iterator<MilitaryPerson> iterator = person.getAllChildren();
            while (iterator.hasNext())
            {
                MilitaryPerson p = iterator.next();
                sum = sum + computerSalary(p);
            }
        }
        
        return sum;
    }
}


interface Unit{
    public void add(Unit... person) ;
    public void remove(Unit person) ;
    public Unit getChild(int index); 
    public Iterator<Unit>  getAllChildren() ;
    public boolean isLeaf();
    public String getInfo();
    public void setNamePhoneNo(String name, String phoneNo);
    
    
    static void printAllInfo(Unit unit)
    {
        if (null == unit)
        {
            return;
        }
        
        System.out.println(unit.getInfo());
        
        if (!unit.isLeaf())
        {
            Iterator<Unit> iterator = unit.getAllChildren();
            while (iterator.hasNext())
            {
                Unit p = iterator.next();
                printAllInfo(p);
            }
        }       
    }
} 

class Dept implements Unit{
    LinkedList<Unit> list;
    String name;
    String phoneNo;
    
    Dept(String name, String phoneNo){
          this.name=name;
          this.phoneNo=phoneNo;
          list = new LinkedList<Unit>();
    } 
    
    public void add(Unit... uint) {
        for (Unit item : uint)
        {
          list.add(item);
        }
    }
    
    public void remove(Unit uint){
          list.remove(uint);
    }
    
    public Unit getChild(int index) {
          return list.get(index); 
    }
    public Iterator<Unit>  getAllChildren() {
          return list.iterator(); 
    }
    public boolean isLeaf(){
         return false;
    } 
    public String getInfo(){
          return name + ": " + phoneNo;
    }
    public void setNamePhoneNo(String name, String phoneNo){
         this.name    = name;
         this.phoneNo = phoneNo;
    }
}


class Staff implements Unit{
    String name;
    String phoneNo;
    
    Staff(String name, String phoneNo){
        this.name=name;
        this.phoneNo=phoneNo;
  }
    
    public void add(Unit... person)  {}
    public void remove (Unit person){}
    public Unit getChild(int index) {
         return null;
    } 
    public Iterator<Unit>  getAllChildren() {
         return null;
    }
    
    
     public boolean isLeaf(){
         return true;
    } 
     
     public String getInfo(){
         return name + ": " + phoneNo;
   }
   public void setNamePhoneNo(String name, String phoneNo){
        this.name    = name;
        this.phoneNo = phoneNo;
   }
}



public class Mod6
{

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        MilitaryOfficer pz = new MilitaryOfficer("paiZhang1", 10000.0);
        MilitaryOfficer bz1 = new MilitaryOfficer("banZhang1", 5000.0);
        MilitaryOfficer bz2 = new MilitaryOfficer("banZhang2", 5000.0);
        
        MilitarySoldier[] ms = new MilitarySoldier[7];
        for (int i = 0; i < ms.length; ++i)
        {
            ms[i] = new MilitarySoldier("sb" + i, 1000);
        }
        
        bz1.add(ms[0]);
        bz1.add(ms[1]);
        
        bz2.add(ms[2]);
        bz2.add(ms[3]);   
        bz2.add(ms[4]);
        
        pz.add(ms[5]);
        pz.add(ms[6]);   
        pz.add(bz1);
        pz.add(bz2);
        
        System.out.println("pa group's salary: " + ComputerSalary.computerSalary(pz));
        
        System.out.println("bz1 group's salary: " + ComputerSalary.computerSalary(bz1));
        System.out.println("bz2 group's salary: " + ComputerSalary.computerSalary(bz2));
        
        
        
        
        //NJPUT
        Dept dept_njupt = new Dept("南邮本部", "88880001");
        Dept dept_yj    = new Dept("研究生部", "88880002");
        Dept dept_dx    = new Dept("大学部",  "88880003");
        Dept dept_yj_gl = new Dept("研究生管理部", "88880004");
        Dept dept_dx_gl = new Dept("大学管理部",  "88880005");    
        
        Staff[] staffs = new Staff[12];
        for (int i = 0; i < staffs.length; ++i)
        {
            staffs[i] = new Staff("人员" + i, (88880006+i)+"");
        }
        
        dept_njupt.add(dept_yj, dept_dx, staffs[0], staffs[1]);
        dept_yj.add(dept_yj_gl, staffs[2], staffs[3], staffs[4]);
        dept_dx.add(dept_dx_gl, staffs[5], staffs[6]);
        dept_yj_gl.add(staffs[7], staffs[8], staffs[9]);
        dept_dx_gl.add(staffs[10], staffs[11]);
        
        Unit.printAllInfo(dept_njupt);
        
    }

}
