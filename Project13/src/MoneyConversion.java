import java.awt.*;
import java.awt.event.*;
public class MoneyConversion extends Frame implements ActionListener  
{
	Label l1,l2,l3;
	Button b;
	TextField t1,t2,t3;
	public MoneyConversion() 
	{
		setLayout(null);
		l1=new Label("Enter no. of rupees per Dollar:");
		l2=new Label("Enter Rupees(₹):");
		l3=new Label("Dollars($):");
		b=new Button("CONVERT IN DOLLARS");
		t1=new TextField(50);
		t2=new TextField(50);
		t3=new TextField(50);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		l1.setBounds(100,100,200,30);
		t1.setBounds(300,100,150,30);
		l2.setBounds(100,140,200,30);
		t2.setBounds(300,140,150,30);
		l3.setBounds(100,180,200,30);
		t3.setBounds(300,180,150,30);
		b.setBounds(150,230,200,40);	
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(b);
		b.addActionListener(this);
	}
	public static void main(String[] args) 
	{
		MoneyConversion m=new MoneyConversion();
		m.setTitle("Rupees to Dollar Converter");
		m.setVisible(true);
		m.setSize(800,500);
	}

	public void actionPerformed(ActionEvent ae) 
	{
		if(b==ae.getSource())
		{
			String s=t1.getText();
			float rupd=Float.parseFloat(s);
			s=t2.getText();
			float ru=Float.parseFloat(s);
			float dol=ru/rupd;
			s=Float.toString(dol);
			t3.setText(s);
		}
	}
}
