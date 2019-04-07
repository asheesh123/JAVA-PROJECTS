import java.awt.*;
import java.awt.event.*;
public class AddSub extends Frame implements ActionListener
{
	TextField t;
	Button b1,b2,b3,b4;
	public AddSub()
	{
		setLayout(null);
		t=new TextField("0",20);
		b1=new Button("ADD 5");
		b2=new Button("SUB 5");
		b3=new Button("ADD 10");
		b4=new Button("SUB 10");
		t.setBounds(100,100,200,30);
		b1.setBounds(100,140,90,30);
		b2.setBounds(210,140,90,30);
		b3.setBounds(100,180,90,30);
		b4.setBounds(210,180,90,30);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		add(t);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
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
		AddSub as=new AddSub();
		as.setSize(800,500);
		as.setTitle("My Frame");
		as.setVisible(true);
		as.setBackground(Color.white);
	}

	public void actionPerformed(ActionEvent ae) 
	{
		int a=0,b;
		String s;
		if(b1==ae.getSource())
		{
			String str=t.getText();
			b=Integer.parseInt(str);
			a=b+5;
			s=Integer.toString(a);
			t.setText(s);
		}
		if(b2==ae.getSource())
		{
			String str=t.getText();
			b=Integer.parseInt(str);
			a=b-5;
			s=Integer.toString(a);
			t.setText(s);
		}
		if(b3==ae.getSource())
		{
			String str=t.getText();
			b=Integer.parseInt(str);
			a=b+10;
			s=Integer.toString(a);
			t.setText(s);
		}
		if(b4==ae.getSource())
		{
			String str=t.getText();
			b=Integer.parseInt(str);
			a=b-10;
			s=Integer.toString(a);
			t.setText(s);
		}
	}

}
