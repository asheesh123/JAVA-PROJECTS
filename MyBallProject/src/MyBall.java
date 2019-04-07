import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class MyBall {
	protected Rectangle location;
	private double dx,dy;
	protected Color color;
	public MyBall(int x,int y,int r)
	{
		location=new Rectangle(x-r, y-r, 2*r, 2*r);
		dx=0;dy=0;
		color=Color.red;
	}
	
	public void setMotion(double ndx,double ndy)
	{
		dx=ndx;
		dy=ndy;
	}
	public int radious()
	{
		return location.width/2;
	}
	public int x()
	{
		return location.x+radious();
	}
	public int y()
	{
		return location.y+radious();
	}
	public double xMotion()
	{
		return dx;
	}
	public double yMotion()
	{
		return dy;
	}

	
	public void move()
	{
		location.translate((int)dx, (int)dy);
	}
	public void paint(Graphics g)
	{
		g.setColor(color);
		g.fillOval(location.x, location.y, location.width, location.height);
	}
}

