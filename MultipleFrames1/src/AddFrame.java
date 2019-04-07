import java.awt.*;
import java.awt.event.*;

public class AddFrame extends Frame implements ActionListener
{
	Label l1;
	TextField t1;
	Button b1;
	MainFrame f;
	public AddFrame(MainFrame f1)
	{
		f=f1;
		setLayout(null);
		l1=new Label("Result:");
		t1=new TextField(40);
		b1=new Button("ADD");
		l1.setBounds(100,100,90,30);
		t1.setBounds(200,100,100,30);
		b1.setBounds(130,140,70,40);
		t1.setEditable(false);
		b1.addActionListener(this);
		add(l1);add(t1);add(b1);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				setVisible(false);
			}
		});
	}
	public void actionPerformed(ActionEvent ae) 
	{
		if(b1==ae.getSource())
		{
			String s1=f.t1.getText();
			String s2=f.t2.getText();
			if(s1.equals("")||s2.equals(""))
			{
				t1.setText("enter numbers");
			}
			else
			{
				float a=Float.parseFloat(s1);
				float b=Float.parseFloat(s2);
				t1.setText(Float.toString(a+b));
			}
			
		}
		
	}
}
