import java.awt.*;
import java.awt.event.*;
public class BorderLayoutExample extends Frame 
{
	Button b1,b2,b3,b4,b5;
	public BorderLayoutExample() 
	{
		b1=new Button("north");
		b2=new Button("south");
		b3=new Button("east");
		b4=new Button("west");
		b5=new Button("center");
		setLayout(new BorderLayout(50,50));
		setBackground(Color.white);
		add(b1,BorderLayout.NORTH);
		add(b2,BorderLayout.SOUTH);
		add(b3,BorderLayout.EAST);
		add(b4,BorderLayout.WEST);
		add(b5,BorderLayout.CENTER);
		b1.setBackground(Color.red);
		b2.setBackground(Color.red);
		b3.setBackground(Color.red);
		b4.setBackground(Color.red);
		b5.setBackground(Color.red);
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
		BorderLayoutExample b=new BorderLayoutExample();
		b.setTitle("BorderLayout Example");
		b.setSize(800,700);
		b.setVisible(true);
	}

}
