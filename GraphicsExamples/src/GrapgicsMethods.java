import java.awt.*;
import java.applet.*;
public class GrapgicsMethods extends Applet 
{
	String s=new String();
	String s1=new String();
	String s2=new String();
	Font f1=new Font("Courier New",Font.BOLD,20);
	public void paint(Graphics g)
	{
		g.setFont(f1);
		g.setColor(Color.cyan);
		g.drawString("asheesh saloni",100,100);
		g.setColor(Color.BLUE);
		g.fillRect(110,110,400,200);
		g.setColor(Color.red);
		g.drawLine(400,100,800,300);
		g.setColor(Color.black);
		g.fillOval(400,300,100,200);
		g.setColor(Color.green);
		g.drawArc(500,150,180,280,90,70);
	}
}
