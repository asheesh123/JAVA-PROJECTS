import java.awt.*;
import java.awt.event.*;
public class AppendExample extends Frame implements ActionListener
{
	TextField t1,t2,t3;
	Button b1;
	public AppendExample() 
	{
		setLayout(new FlowLayout());
		t1=new TextField("asheesh",30);
		t2=new TextField("vishvkarma",30);
		t3=new TextField(60);
		b1=new Button("APPEND");
		this.add(t1);
		this.add(t2);
		this.add(b1);
		this.add(t3);
		b1.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		
	}

	public static void main(String[] args) 
	{
		AppendExample ap=new AppendExample();
		ap.setSize(1200,300);
		ap.setTitle("My Frame");
		ap.setVisible(true);
		ap.setBackground(Color.LIGHT_GRAY);
		
	}

	public void actionPerformed(ActionEvent ae) 
	{
		if(b1==ae.getSource())
		{
			String s1=t1.getText();
			String s2=t2.getText();
			String s=s1+" "+s2;
			t3.setText(s);
		}
	}

}
