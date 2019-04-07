import java.awt.*;
import java.applet.*;
public class SimpleImageLoad extends Applet
{
	Image img;
	public void init()
	{
		img=getImage(getDocumentBase(),getParameter("img"));
	}
	public void paint(Graphics g)
	{
		g.drawImage(img,0,0,this);
	}

}
