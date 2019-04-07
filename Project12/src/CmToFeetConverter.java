import java.awt.*;
import java.awt.event.*;
public class CmToFeetConverter extends Frame implements ActionListener
{
	Label l1,l2;
	Button b;
	TextField t1,t2;
	public CmToFeetConverter() 
	{
		setLayout(null);
		l1=new Label("Enter length in cm:");
		l2=new Label("Length in feet is:");
		t1=new TextField(50);
		t2=new TextField(50);
		b=new Button("CONVERT");
		l1.setBounds(100,100,200,30);
		t1.setBounds(300,100,150,30);
		l2.setBounds(100,140,200,30);
		t2.setBounds(300,140,150,30);
		b.setBounds(150,230,200,40);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
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
		CmToFeetConverter c=new CmToFeetConverter();
		c.setSize(800,500);
		c.setTitle("CM to FEET converter");
		c.setVisible(true);
		c.setBackground(Color.cyan);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(b==ae.getSource())
		{
			String s=t1.getText();
			float cm=Float.parseFloat(s);
			float fo=(float) (cm/30.48);
			s=Float.toString(fo);
			t2.setText(s);
		}
	}
}
