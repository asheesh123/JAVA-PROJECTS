import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyBallExample extends Frame{
	public static void main(String[] args) throws InterruptedException {
		MyBallExample world=new MyBallExample();
		world.setVisible(true);
		world.setSize(FrameWidth,FrameHeight);
		world.setTitle("Ball World");
	}
	public static final int FrameWidth=300;
	public static final int FrameHeight=200;
	private MyBall aBall;
	private int counter=0;
	public MyBallExample()
	{
		
		aBall=new MyBall(10,15,10);
		
		aBall.setMotion(6.0, 9.0);
		repaint();
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { System.exit(0);}
});
		
	}
	public void paint(Graphics g)
	{
		aBall.paint(g);
		aBall.move();
		if(aBall.x()<0||aBall.x()>FrameWidth)
		{
			aBall.setMotion(-aBall.xMotion(), aBall.yMotion());
			//aBall.setMotion(-20,20);
		}
		if(aBall.y()<0||aBall.y()>FrameHeight)
		{
			aBall.setMotion(aBall.xMotion(), -aBall.yMotion());
		//	aBall.setMotion(20,-20);
		}
		counter++;
		if(counter<5000)
		{
			repaint();
			try {
			Thread.sleep(25);
			}
			catch(InterruptedException e)
			{
				
			}
		}
		else
			System.exit(0);
		
	}
	


}
