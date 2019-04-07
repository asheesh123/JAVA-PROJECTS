import java.awt.*;
import java.awt.event.*;

public class CopyExample extends Frame implements ActionListener 
{
	TextField t1,t2;
	Button b1;
	public CopyExample(Frame frame) 
	{
		this.setLayout(new FlowLayout());
		t1=new TextField("asheesh vishvkarma",30);
		t2=new TextField(30);
		b1=new Button("COPY PASTE");
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
	public void actionPerformed(ActionEvent ae)
	{
		if(b1==ae.getSource())
		{
			System.out.println(ae.toString());//ptint object in from of string'/;p=lp=lp=lpzzzzzzzzzzz
			String s=t1.getText();
			t2.setText(s);
		}
	}
	public static void main(String[] args) 
	{
		CopyExample cp=new CopyExample(new Frame());
		cp.setTitle("my frame");
		cp.setVisible(true);
		cp.setSize(1200,900);
		

	}

}
