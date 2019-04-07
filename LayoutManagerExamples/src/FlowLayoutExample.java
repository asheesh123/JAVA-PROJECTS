import java.awt.*;
import java.awt.event.*;

public class FlowLayoutExample extends Frame 
{
	public FlowLayoutExample()
	{
		setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
		//setLayout(new FlowLayout(FlowLayout.LEFT,15,15));
		//setLayout(new FlowLayout(FlowLayout.RIGHT,15,15));
		for(int i=10;i<100;i++)
		{
			add(new Button("    "+i+"   "));
		}
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	public static void main(String[] args)
	{
		FlowLayoutExample f=new FlowLayoutExample();
		f.setVisible(true);
		f.setTitle("FlowLayout Example");
		f.setSize(800,700);	
		f.setBackground(Color.white);
		Font font=new Font(Font.DIALOG,1,10);
		f.setFont(font);
	}
}
