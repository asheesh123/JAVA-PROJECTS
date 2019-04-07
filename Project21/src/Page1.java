import java.awt.*;
import java.awt.event.*;
public class Page1 extends Frame implements ActionListener 
{
	Label l1,l2,l3,l4,l;
	Choice c1,c2;
	Button b1;
	public Page1() 
	{
		setLayout(null);
		l1=new Label("State Bank Collect");
		l2=new Label("Select Bank and Type of Corporate/Institute");
		l3=new Label("State of Corporate/Institute*");
		l4=new Label("Type of Corporate/Institute*");
		l=new Label("select first");
		c1=new Choice();
		c2=new Choice();
		b1=new Button("GO");
		c1.add("--Select State--");
		c1.add("All India");
		c1.add("Andhra Pradesh");
		c1.add("Uttar Pradesh");
		c2.add("--Select Type--");
		c2.add("Educational Institution");
		c2.add("Industry");
		c2.add("Others");
		
		l1.setBounds(200,100,500,40);
		l2.setBounds(100,200,700,40);
		l3.setBounds(100,260,500,40);
		c1.setBounds(600,260,300,40);
		l4.setBounds(100,320,500,40);
		c2.setBounds(600,320,500,40);
		
		b1.setBounds(300,380,80,40);
		l.setBounds(300,450,200,40);
		c1.setBackground(Color.cyan);
		l.setVisible(false);
		c2.setBackground(Color.cyan);
		b1.setBackground(Color.cyan);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(c1);
		add(l);
		add(b1);
		add(c2);
		b1.addActionListener(this);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	public static void main(String[] args)
	{
		Page1 p=new Page1();
		p.setVisible(true);
		p.setTitle("Page1");
		Toolkit t=p.getToolkit();
		Dimension d=t.getScreenSize();
		p.setSize(d.width,d.height);
		p.setBackground(Color.magenta);
		p.setFont(new Font(Font.DIALOG,Font.PLAIN,25));
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(b1==ae.getSource())
		{
			if(c1.getSelectedIndex()==0||c2.getSelectedIndex()==0)
			{
				l.setVisible(true);
			}
			else
			{
				Page2 p=new Page2();
				p.setVisible(true);
				p.setTitle("Page2");
				Toolkit t=p.getToolkit();
				Dimension d=t.getScreenSize();
				p.setSize(d.width,d.height);
				p.setBackground(Color.pink);
				p.setFont(new Font(Font.DIALOG,Font.PLAIN,25));
			}
		}
	}
}
