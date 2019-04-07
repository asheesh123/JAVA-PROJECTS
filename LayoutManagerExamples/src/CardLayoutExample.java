import java.awt.*;
import java.awt.datatransfer.FlavorEvent;
import java.awt.event.*;
import java.text.ParseException;
public class CardLayoutExample extends Frame implements ActionListener
{
	Panel p1,p2,mp;
	CardLayout cd;
	Button b1,b2,b3,b4;
	TextField t1,t2,t3,t4,t5,t6;
	Label l1,l2,l3,l4,l5,l6;
	public CardLayoutExample() 
	{
		setLayout(new FlowLayout());
		p1=new Panel();
		p2=new Panel();
		t1=new TextField(20);
		cd=new CardLayout(50,20);
		mp=new Panel();
		mp.setLayout(cd);
		b1=new Button("ADDITION");
		b2=new Button("SUBTRACTION");
		p1=new Panel(new FlowLayout());
		p2=new Panel(new FlowLayout());
		t1=new TextField(20);
		t2=new TextField(20);
		t3=new TextField(20);
		b3=new Button("ADD");
		l1=new Label("NUMBER1:");
		l2=new Label("NUMBER2:");
		l3=new Label("RESULT:");
		add(b1);
		add(b2);
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(l3);
		p1.add(t3);
		p1.add(b3);
		p1.setBackground(Color.green);
		p2.setBackground(Color.red);
		mp.add(p1,"addition");
		l4=new Label("NUMBER1:");
		l5=new Label("NUMBER2:");
		l6=new Label("RESULT:");
		t4=new TextField(20);
		t5=new TextField(20);
		t6=new TextField(20);
		b4=new Button("SUB");
		p2.add(l4);
		p2.add(t4);
		p2.add(l5);
		p2.add(t5);
		p2.add(l6);
		p2.add(t6);
		p2.add(b4);
		mp.add(p2,"subtraction");
		add(mp);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
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
		CardLayoutExample c=new CardLayoutExample();
		c.setTitle("CardLayout Example");
		c.setVisible(true);
		c.setSize(800,700);
		c.setBackground(Color.white);
		c.setFont(new Font(Font.DIALOG,Font.BOLD,11));
	}
	public void actionPerformed(ActionEvent a) 
	{
		if(b1==a.getSource())
		{
			cd.next(mp);
			//cd.show(mp,"addition");
		}
		if(b2==a.getSource())
		{
			//cd.last(mp);
			cd.show(mp,"subtraction");
		}
		if(b3==a.getSource())
		{
			try
			{
				float x=Float.parseFloat(t1.getText());
				float y=Float.parseFloat(t2.getText());
				t3.setText(Float.toString(x+y));
			}
			catch(Exception e)
			{
				t3.setText("its non-numeric");
			}
		}
		if(b4==a.getSource())
		{
			try
			{
				float x=Float.parseFloat(t4.getText());
				float y=Float.parseFloat(t5.getText());
				t6.setText(Float.toString(x-y));
			}
			catch(Exception e)
			{
				t6.setText("its non-numeric");
			}
		}
	}
}