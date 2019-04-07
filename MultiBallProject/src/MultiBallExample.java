import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class MultiBallExample extends Frame {
	public static void main(String[] args) throws InterruptedException {
		MultiBallExample world=new MultiBallExample();
		world.setVisible(true);
		world.setSize(FrameWidth,FrameHeight);
		world.setTitle("Ball World");
	}
	public static final int FrameWidth=300;
	public static final int FrameHeight=200;
	private MultiBall mBalls[];
	private int counter=0;
	public MultiBallExample()
	{
		
		mBalls=new MultiBall[5];
		for(int i=0;i<5;i++)
		{
			mBalls[i]=new MultiBall(10,15,10);
			if(i==1)
			mBalls[i].setColor(Color.red);
			if(i==2)
				mBalls[i].setColor(Color.blue);
			if(i==3)
				mBalls[i].setColor(Color.black);
			if(i==4)
				mBalls[i].setColor(Color.cyan);
			if(i==5)
				mBalls[i].setColor(Color.gray);
			mBalls[i].setMotion(6.0+i,9.0-i);	
			
		}
		repaint();
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { System.exit(0);}});
		
	}
	
	public void paint(Graphics g)
	{
		for(int i=0;i<5;i++)
		{
			mBalls[i].paint(g);
			mBalls[i].move();
			if(mBalls[i].x()<0||mBalls[i].x()>FrameWidth)
			{
				mBalls[i].setMotion(-mBalls[i].xMotion(), mBalls[i].yMotion());
			//aBall.setMotion(-20,20);
			}
			if(mBalls[i].y()<0||mBalls[i].y()>FrameHeight)
			{
				mBalls[i].setMotion(mBalls[i].xMotion(), -mBalls[i].yMotion());
		//		aBall.setMotion(20,-20);
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
}
