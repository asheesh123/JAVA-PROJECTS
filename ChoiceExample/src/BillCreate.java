import java.awt.*;
import java.awt.event.*;

public class BillCreate extends Frame implements ActionListener 
{
	Label l1,l2,l3,l4,l5,l6,l7;
	TextField t1,t2,t3,t4,t5;
	Choice c1,c2;
	int kp=1000,wp=800,mp=500;
	int dp=40000,hp=45000;
	public BillCreate() 
	{
		setLayout(null);
		l1=new Label("S.No");
		l2=new Label("Item");
		l3=new Label("Quantity");
		l4=new Label("Price");
		l5=new Label("1");
		l6=new Label("2");
		l7=new Label("Total Amount");
		
		t1=new TextField(100);
		t2=new TextField(100);
		t3=new TextField(100);
		t4=new TextField(100);
		t5=new TextField(100);
		
		c1=new Choice();
		c2=new Choice();
		
		c1.add("Kali Linux");
		c1.add("Windows 10");
		c1.add("Mint");
		
		c2.add("dell");
		c2.add("hp");
		
		l1.setBounds(200,200,150,50);
		l5.setBounds(200,300,150,50);
		l6.setBounds(200,400,150,50);
		
		l2.setBounds(400,200,150,50);
		c1.setBounds(400,300,160,50);
		c2.setBounds(400,400,160,50);
		
		l3.setBounds(600,200,150,50);
		t1.setBounds(600,300,150,50);
		t3.setBounds(600,400,150,50);
		
		l4.setBounds(800,200,150,50);
		t2.setBounds(800,300,150,50);
		t4.setBounds(800,400,150,50);
		
		l7.setBounds(200,500,200,50);
		t5.setBounds(600,500,350,50);
		add(l1);add(l2);add(l3);add(l4);add(l5);add(c1);add(t1);add(t2);add(l6);add(c2);add(t3);add(t4);add(l7);add(t5);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		t1.addActionListener(this);
		t3.addActionListener(this);
		t5.addActionListener(this);
		
		
	}
	public static void main(String[] args) 
	{
		BillCreate b=new BillCreate();
		b.setSize(1000,700);
		b.setVisible(true);
		b.setTitle("Bill Creatrer");
		Font f=new Font(Font.DIALOG, 1, 20);
		b.setFont(f);
		b.setBackground(Color.white);
	}
	public void actionPerformed(ActionEvent ae) 
	{
		if(t1==ae.getSource())
		{
			String s=t1.getText();
			int q,price;
			if(s.equals(""))
			{
				q=0;
				t1.setText("0");
			}
			else
			{
				q=Integer.parseInt(s);
			}
			String s1=c1.getSelectedItem();
			if(s1.equals("Kali Linux"))
			{
				price=q*kp;
				t2.setText(Integer.toString(price));
			}
			if(s1.equals("Windows 10"))
			{
				price=q*wp;
				t2.setText(Integer.toString(price));
			}
			if(s1.equals("Mint"))
			{
				price=q*mp;
				t2.setText(Integer.toString(price));
			}
		}
		if(t3==ae.getSource())
		{
			String s=t2.getText();
			int q,price;
			if(s.equals(""))
			{
				q=0;
				t1.setText("0");
			}
			else
			{
				q=Integer.parseInt(s);
			}
			String s1=c2.getSelectedItem();
			if(s1.equals("dell"))
			{
				price=q*dp;
				t4.setText(Integer.toString(price));
			}
			if(s1.equals("hp"))
			{
				price=q*hp;
				t4.setText(Integer.toString(price));
			}
		}
		if(t5==ae.getSource())
		{
			int p1=Integer.parseInt(t2.getText());
			int p2=Integer.parseInt(t4.getText());
			int p=p1+p2;
			t5.setText(Integer.toString(p));
			
		}
	}
}
