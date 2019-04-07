import java.awt.*;
import java.awt.event.*;

public class Area extends Frame implements ActionListener
{
	Button b1,b2,b3,b4,b5;
	
	Area()
	{
		setLayout(null);
		b1=new Button("CIRCLE");
		b2=new Button("SQUARE");
		b3=new Button("RECTANGLE");
		b4=new Button("TRIANGLE");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		
		b1.setBounds(200,200,150,50);
		b2.setBounds(400,200,150,50);
		b3.setBounds(200,300,150,50);
		b4.setBounds(400,300,150,50);
		
		add(b1);add(b2);add(b3);add(b4);
		b1.setBackground(Color.GREEN);
		b2.setBackground(Color.GREEN);
		b3.setBackground(Color.GREEN);
		b4.setBackground(Color.GREEN);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
	public static void main(String[] args) 
	{
		Area a=new Area();
		a.setVisible(true);
		a.setBackground(Color.CYAN);
		a.setSize(800,700);
		a.setTitle("Area Calculator");
		Font f=new Font(Font.DIALOG,0,20);
		a.setFont(f);
	}

	public void actionPerformed(ActionEvent ae) 
	{
		if(b1==ae.getSource())
		{
			
		}
		if(b2==ae.getSource())
		{
			
		}
		if(b3==ae.getSource())
		{
			
		}
		if(b4==ae.getSource())
		{
			
		}
	}
}
