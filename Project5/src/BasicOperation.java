import java.awt.*;
import java.awt.event.*;
public class BasicOperation extends Frame implements ActionListener
{
	Label l1,l2,l3;
	TextField t1,t2,t3;
	Button b1,b2,b3,b4,b5;
	public BasicOperation() 
	{
		setLayout(null);
		l1=new Label("Number 1:");
		l2=new Label("Number 2:");
		l3=new Label("Result:");
		t1=new TextField("1",10);
		t2=new TextField("2",10);
		t3=new TextField(10);
		b1=new Button("ADD");
		b2=new Button("SUB");
		b3=new Button("MUL");
		b4=new Button("DIV");
		b5=new Button("MOD");
		l1.setBounds(100,100,70,25);
		t1.setBounds(180,100,150,25);
		l2.setBounds(100,130,70,25);
		t2.setBounds(180,130,150,25);
		l3.setBounds(100,170,70,25);
		t3.setBounds(180,170,150,25);
		b1.setBounds(100,210,90,25);
		b2.setBounds(240,210,90,25);
		b3.setBounds(100,250,80,25);
		b4.setBounds(250,250,90,25);
		b5.setBounds(170,250,90,25);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) 
	{
		BasicOperation b=new BasicOperation();
		b.setSize(1200,900);
		b.setVisible(true);
		b.setTitle("My Frame");
		b.setBackground(Color.white);
	}

	public void actionPerformed(ActionEvent ae) 
	{
		String s=t1.getText();
		float a=Float.parseFloat(s);
		s=t2.getText();
		float b=Float.parseFloat(s);
		float c;
		if(b1==ae.getSource())
		{
			c=a+b;
			s=Float.toString(c);
			t3.setText(s);
		}
		if(b2==ae.getSource())
		{
			c=a-b;
			s=Float.toString(c);
			t3.setText(s);
		}
		if(b3==ae.getSource())
		{
			c=a*b;
			s=Float.toString(c);
			t3.setText(s);
		}
		if(b4==ae.getSource())
		{
			c=a/b;
			s=Float.toString(c);
			t3.setText(s);
		}
		if(b5==ae.getSource())
		{
			c=a%b;
			s=Float.toString(c);
			t3.setText(s);
		}
	}
}
