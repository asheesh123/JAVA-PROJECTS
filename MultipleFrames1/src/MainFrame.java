import java.awt.*;
import java.awt.event.*;
public class MainFrame extends Frame implements ActionListener
{
	Label l1,l2;
	TextField t1,t2;
	Button b1;
	public MainFrame() 
	{
		setLayout(null);
		l1=new Label("Number1:");
		l2=new Label("Number2:");
		t1=new TextField(30);
		t2=new TextField(30);
		b1=new Button("NEW");
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				setVisible(false);
			}
		});
		l1.setBounds(100,100,90,30);
		t1.setBounds(200,100,100,30);
		l2.setBounds(100,140,90,30);
		t2.setBounds(200,140,100,30);
		b1.setBounds(150,200,70,40);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(b1);
		b1.addActionListener(this);
		
	}
	public static void main(String[] args) 
	{
		MainFrame m=new MainFrame();
		m.setVisible(true);
		m.setSize(800,500);
		m.setTitle("MainFrame");
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(b1==ae.getSource())
		{
			AddFrame f=new AddFrame(this);
			f.setTitle("AddFrame");
			f.setVisible(true);
			f.setSize(600,500);
		}	
	}
}
