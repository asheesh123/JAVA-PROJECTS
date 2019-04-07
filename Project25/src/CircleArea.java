import java.awt.*;
import java.awt.event.*;
public class CircleArea extends Frame implements ActionListener
{
	Button b1;
	TextField t1,t2;
	Label l1,l2;
	CircleArea()
	{
		setLayout(null);
		l1=new Label("Radius:");
		l2=new Label("Area:");
		t1=new TextField(70);
		t2=new TextField(70);
		b1=new Button("RESULT");
		add(l1);add(t1);add(l2);add(t2);add(b1);
		l1.setBounds(200,200,200,50);
		l2.setBounds(200,300,200,50);
		
		t1.setBounds(410,200,200,50);
		t2.setBounds(410,300,200,50);
		
		b1.setBounds(260,400,150,50);
		b1.addActionListener(this);
		t2.setEditable(false);
		b1.setBackground(Color.CYAN);
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
			String s=t1.getText();
			if(s.equals(""))
			{
				t2.setText("give parameter");
			}
			else
			{
				float r=Float.parseFloat(t1.getText());
				t2.setText(Float.toString((float) (3.14*r*r)));
			}
		}
	}
}
