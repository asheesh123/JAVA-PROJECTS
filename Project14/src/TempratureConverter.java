import java.awt.*;
import java.awt.event.*;
public class TempratureConverter extends Frame implements ActionListener 
{
	Label l1,l2;
	TextField t1,t2;
	Button  b;
	public TempratureConverter()
	{
		setLayout(null);
		l1=new Label("Temperature(°C):");
		l2=new Label("Temperature(°F):");
		t1=new TextField(40);
		t2=new TextField(40);
		b=new Button("CONVERT");
		this.addWindowListener(new WindowAdapter() 
		{
			public  void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		b.addActionListener(this);
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		add(b);
		l1.setBounds(100,100,150,30);
		t1.setBounds(250,100,200,30);
		l2.setBounds(100,140,150,30);
		t2.setBounds(250,140,200,30);
		b.setBounds(150,190,150,35);
		
	}
	public static void main(String[] args)
	{
		TempratureConverter tc=new TempratureConverter();
		tc.setTitle("Temprature Converter");
		tc.setVisible(true);
		tc.setSize(800,500);
		tc.setBackground(Color.white);
		
		
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(b==ae.getSource())
		{
			String s1=t1.getText();
			String s2=t2.getText();
			if(s1.equals(""))
			{
				float f=Float.parseFloat(s2);
				float c=((f-32)*5)/9;
				s1=Float.toString(c);
				t1.setText(s1);
			}
			if(s2.equals(""))
			{
				float c=Float.parseFloat(s1);
				float f=((c*9)/5)+32;
				s2=Float.toString(f);
				t2.setText(s2);
			}
		}
	}

}
