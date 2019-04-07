import java.awt.*;
import java.awt.event.*;
public class Page2 extends Frame implements ActionListener
{
	Label l1,l2,l3,l;
	Choice c1,c2;
	Button b1,b2;
	public Page2() 
	{
		setLayout(null);
		l1=new Label("State Bank Collect");
		l2=new Label("Select from Educational Institutions");
		l3=new Label("State Institute name*");
		l=new Label("select first");
		c1=new Choice();
		b1=new Button("SUBMIT");
		b2=new Button("CANCEL");
		c1.add("--Select Educational Institute--");
		c1.add("ABC School");
		c1.add("NIT ANDHRA PRADESH");
		c1.add("MNNIT ALLAHABAD");
				
		l1.setBounds(200,100,500,40);
		l2.setBounds(100,200,700,40);
		l3.setBounds(100,260,500,40);
		c1.setBounds(600,260,500,40);
		
		b1.setBounds(300,380,150,40);
		b2.setBounds(500,380,150,40);
		l.setBounds(300,450,200,40);
		c1.setBackground(Color.cyan);
		l.setVisible(false);
		b1.setBackground(Color.cyan);
		b2.setBackground(Color.cyan);
	
		add(l1);
		add(l2);
		add(l3);
		add(c1);
		add(l);
		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
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
			if(c1.getSelectedIndex()==0)
			{
				l.setVisible(true);
			}
			else
			{
				Page3 p=new Page3();
				p.setVisible(true);
				p.setTitle("Page3");
				Toolkit t=p.getToolkit();
				Dimension d=t.getScreenSize();
				p.setSize(d.width,d.height);
				p.setBackground(Color.white);
				p.setFont(new Font(Font.DIALOG,Font.PLAIN,20));
			}
		}
		if(b2==ae.getSource())
		{
			setVisible(false);
		}	
	}
}
