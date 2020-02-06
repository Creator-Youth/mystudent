package json;

public class Point 
{
     double X;
     double Y;
      Point(double X,double Y)
      {
    	  this.X=X;
    	  this.Y=Y;   			  
      }
	public double getX() {
		return X;
	}
	public void setX(double x) {
		X = x;
	}
	public double getY() {
		return Y;
	}
	public void setY(double y) {
		Y = y;
	}
    
	public String toString ()
	{
		return "X:"+X+",Y:"+Y;
	}
}
