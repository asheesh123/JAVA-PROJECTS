import java.awt.*;
import java.awt.event.*;
public class TriangleArea extends Frame implements ActionListener
{
	Button b1;
	TextField t1,t2,t3;
	Label l1,l2,l3;
	TriangleArea()
	{
		setLayout(null);
		l1=new Label("Base:");
		l2=new Label("Height:");
		l3=new Label("Area");
		t1=new TextField(70);
		t2=new TextField(70);
		t3=new TextField(70);
		b1=new Button("RESULT");
		b1.setBackground(Color.CYAN);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(b1);
		b1.addActionListener(this);
		l1.setBounds(200,200,200,50);
		t1.setBounds(410,200,200,50);
		
		l2.setBounds(200,300,200,50);
		t2.setBounds(410,300,200,50);
		l3.setBounds(200,400,200,50);
		t3.setBounds(410,400,200,50);
		
		
		b1.setBounds(260,500,150,50);
		t3.setEditable(false);
		addWindowListener(new WindowAdapter()
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
			String s1=t1.getText();
			String s2=t2.getText();
			if(s1.equals("")||s2.equals(""))
			{
				t3.setText("give parameters");
			}
			else
			{
				float b=Float.parseFloat(t1.getText());
				float h=Float.parseFloat(t2.getText());
				float area=(b*h)/2;
				t3.setText(Float.toString(area));
			}
		}
	}
}
