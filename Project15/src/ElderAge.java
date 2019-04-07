import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;
public class ElderAge extends Frame implements ActionListener
{
	Label l1,l2,l;
	TextField t1,t2;
	Button b;
	public ElderAge()
	{
		setLayout(null);
		l1=new Label("Person1 dob( dd/MM/yyyy):");
		l2=new Label("Person2 dob( dd/MM/yyyy):");
		t1=new TextField(40);
		l=new Label("");
		t2=new TextField(40);
		b=new Button("CHOOSE ELDER");
		l.setBounds(100,100,400,30);
		l1.setBounds(100,140,190,30);
		t1.setBounds(300,140,200,30);
		l2.setBounds(100,180,190,30);
		t2.setBounds(300,180,200,30);
		b.setBounds(180,220,150,40);
		add(l);
		add(l1);
		add(t1);
		add(t2);
		add(l2);
		add(b);
		b.addActionListener(this);
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
		ElderAge ea=new ElderAge();
		ea.setSize(800,500);
		ea.setTitle("My Calculator");
		ea.setVisible(true);
		ea.setBackground(Color.white);
	}
	public void actionPerformed(ActionEvent ae) 
	{
		if(b==ae.getSource())
		{
			String s1=t1.getText();
			String s2=t2.getText();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
			Date d1,d2;
			try
			{
			    d1=df.parse(s1);
			    d2=df.parse(s2);
			    if(d1.compareTo(d2)>0)
				{
					l.setText("Person1 is Elder than Person2");
				}
			    else if(d1.compareTo(d2)<0)
			    {
			    	l.setText("Person2 is Elder than Person1");
			    }
			    else
			    	l.setText("No difference in age");    
			} 
			catch (ParseException e) 
			{
			    e.printStackTrace();
			    l.setText("error in date format");
			}
		}
	}
}
