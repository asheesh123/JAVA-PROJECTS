import java.awt.*;
import java.awt.event.*;

public class CutExample extends Frame implements ActionListener
{
	TextField t1,t2;
	Button b1;
	public CutExample(Frame frame) 
	{
		setLayout(new FlowLayout());
		t1=new TextField("asheesh vishvkaema",30);
		t2=new TextField(30);
		b1=new Button("CUT PASTE");
		this.add(t1);
		this.add(b1);
		this.add(t2);
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
		CutExample c=new CutExample(new Frame());
		c.setSize(1200,900);
		c.setTitle("MyFrame");
		c.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) 
	{
		if(b1==ae.getSource())
		{
			String s=t1.getText();
			t2.setText(s);
			t1.setText("");
		}
		
	}

}
