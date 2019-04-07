import java.awt.*;
import java.awt.event.*;
public class Area extends Frame implements ActionListener
{
	Button b1,b2,b3,b4;
	Area()
	{
		setLayout(null);
		b1=new Button("Circle");
		b2=new Button("Triangle");
		b3=new Button("Square");
		b4=new Button("Rectangle");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		b1.setBounds(200,200,150,50);
		b2.setBounds(400,200,150,50);
		b3.setBounds(200,300,150,50);
		b4.setBounds(400,300,150,50);
		
		b1.setBackground(Color.CYAN);
		b2.setBackground(Color.CYAN);
		b3.setBackground(Color.CYAN);
		b4.setBackground(Color.CYAN);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	public static void main(String str[])
	{
		Area a=new Area();
		a.setTitle("Area Calculator");
		a.setVisible(true);
		a.setSize(800,700);
		a.setBackground(Color.magenta);
		Font f=new Font(Font.DIALOG,1,20);
		a.setFont(f);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(b1==ae.getSource())
		{
			CircleArea c=new CircleArea();
			c.setSize(800,700);
			c.setVisible(true);
			c.setTitle("Circle Area");
			c.setBackground(Color.BLUE);
			Font f=new Font(Font.DIALOG,1,20);
			c.setFont(f);
		}

		if(b2==ae.getSource())
		{
			TriangleArea t=new TriangleArea();
			t.setSize(800,700);
			t.setVisible(true);
			t.setTitle("Triangle Area");
			t.setBackground(Color.BLUE);
			Font f=new Font(Font.DIALOG,1,20);
			t.setFont(f);
		}
		if(b3==ae.getSource())
		{
			SquareArea t=new SquareArea();
			t.setSize(800,700);
			t.setVisible(true);
			t.setTitle("Square Area");
			t.setBackground(Color.yellow);
			Font f=new Font(Font.DIALOG,1,20);
			t.setFont(f);
		}
		
		if(b4==ae.getSource())
		{
			RectangleArea t=new RectangleArea();
			t.setSize(800,700);
			t.setVisible(true);
			t.setTitle("Rectangle Area");
			t.setBackground(Color.yellow);
			Font f=new Font(Font.DIALOG,1,20);
			t.setFont(f);
		}
	}
}
