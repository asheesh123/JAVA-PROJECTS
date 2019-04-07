import java.awt.*;
import java.awt.event.*;
public class BiggestOfThree extends Frame implements ActionListener
{
	Label l1,l2,l3,l4;
	TextField t1,t2,t3,t4;
	Button b1;
	public BiggestOfThree() 
	{
		setLayout(null);
		l1=new Label("Number 1:");
		l2=new Label("Number 2:");
		l3=new Label("Number 3:");
		l4=new Label("Result:");
		t1=new TextField("20",10);
		t2=new TextField("30",10);
		t3=new TextField("5",10);
		t4=new TextField(10);
		b1=new Button("BIGGEST NUMBER");
		l1.setBounds(100,100,65,30);
		t1.setBounds(200,100,100,30);
		l2.setBounds(100,150,65,30);
		t2.setBounds(200,150,100,30);
		l3.setBounds(100,200,65,30);
		t3.setBounds(200,200,100,30);
		l4.setBounds(100,250,65,30);
		t4.setBounds(200,250,100,30);
		b1.setBounds(120,300,200,30);
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(b1);
		b1.addActionListener(this);
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
		BiggestOfThree big=new BiggestOfThree();
		big.setTitle("My Frame");
		big.setVisible(true);
		big.setSize(1200,900);
		big.setBackground(Color.white);
	}
	public void actionPerformed(ActionEvent ae) 
	{
		if(b1==ae.getSource())
		{
			String  s=t1.getText();
			int a;
			if(s.equals(""))
			{
				t1.setText("0");
				a=0;
			}
			else
			{
				a=Integer.parseInt(s);
			}
			s=t2.getText();
			int b;
			if(s.equals(""))
			{
				b=0;
				t2.setText("0");
			}
			else
			{
				b=Integer.parseInt(s);
			}
			s=t3.getText();
			int c;
			if(s.equals(""))
			{
				c=0;
				t3.setText("0");
			}
			else
			{
				c=Integer.parseInt(s);
			}
			
			int max=a;
			if(max<b)
				max=b;
			if(max<c)
				max=c;
			s=Integer.toString(max);
			t4.setText(s);
		}
	}

}
