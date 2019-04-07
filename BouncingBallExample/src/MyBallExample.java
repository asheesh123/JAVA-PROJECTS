import java.awt.*;
import java.awt.event.*;
public class MyBallExample extends Frame
{
	public static final int FrameWidth=600;
	public static final int FrameHeight=100;
	private MyBall aBall;
	private int counter=0;
	
	public MyBallExample(Color ballcolor)
	{
		aBall=new MyBall(10,15,15);
		aBall.setMotion(50.0,50.0);
		repaint();
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) throws InterruptedException
	{
		MyBallExample world=new MyBallExample(Color.red);
		world.setVisible(true);
		world.setSize(FrameWidth,FrameHeight);
		world.setTitle("Ball World");
		world.setBackground(Color.white);
		Toolkit t=world.getToolkit();
		Dimension d=t.getScreenSize();
		//world.setBounds(350,50,600,600);
		
	}
	public void paint(Graphics g)
	{
		aBall.paint(g);
		aBall.move();
		if(aBall.x()<0||aBall.x()>FrameWidth)
		{
			aBall.setMotion(-aBall.xMotion(),aBall.yMotion());
		}
		if(aBall.y()<0||aBall.y()>FrameWidth)
		{
			aBall.setMotion(aBall.xMotion(),-aBall.yMotion());
		}
		counter++;
		if(counter<5000)
		{
			repaint();
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {}
		}
		else
		{
			System.exit(0);
		}
	}
}
