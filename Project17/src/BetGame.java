import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class BetGame extends Frame  implements ActionListener
{
	Label l1,l2,l3,ln,lu,lb,lm1,lm2,lm3;
	Button bh,bl,b1,b2;
	float balance=100;
	TextField t1;
	Checkbox c1,c2,c3,c4,c5;
	CheckboxGroup cbg;
	TextField tb;
	public BetGame()
	{
		setLayout(null);
		lm1=new Label("HIGH means >=500");
		lm2=new Label("LOW means <=500");
		lm3=new Label("Lucky Range 499 to 501");
		b1=new Button("*2");
		lu=new Label("Lucky bet (Rupees)risk!!");
		b2=new Button("/2");
		l3=new Label("Amount(p):");
		bh=new Button("HIGH");
		bl=new Button("LOW");
		t1=new TextField("10");
		lb=new Label("YOUR BALANCE:");
		ln=new Label("generated number was :");
		l1=new Label();
		l2=new Label();
		tb=new TextField("1000");
		cbg=new CheckboxGroup();
		c1=new Checkbox("0",true,cbg);
		c2=new Checkbox("50",false,cbg);
		c3=new Checkbox("200",false,cbg);
		c4=new Checkbox("500",false,cbg);
		c5=new Checkbox("1000",false,cbg);
		l3.setBounds(100,100,80,30);
		t1.setBounds(180,100,90,30);
		b1.setBounds(100,140,80,30);
		b2.setBounds(190,140,80,30);
		
		lm1.setBounds(100,200,150,40);
		lm2.setBounds(100,240,150,40);
		ln.setBounds(300,260,200,30);
		bh.setBounds(300,300,80,40);
		bl.setBounds(390,300,80,40);
		lb.setBounds(400,150,100,30);
		tb.setBounds(510,150,200,30);
		lm3.setBounds(550,210,200,25);
		lu.setBounds(550,250,200,25);
		c1.setBounds(550,280,100,25);
		c2.setBounds(550,310,100,25);
		c3.setBounds(550,340,100,25);
		c4.setBounds(550,370,100,25);
		c5.setBounds(550,400,100,25);
		t1.setEditable(false);
		tb.setEditable(false);
		add(bh);add(bl);add(lb);add(tb);add(b1);add(b2);add(l1);add(l2);
		add(c1);add(c2);add(c3);add(c4);add(c5);add(lu);add(l3);add(t1);
		add(ln);add(lm1);add(lm2);add(lm3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		bh.addActionListener(this);
		bl.addActionListener(this);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	public static void main(String args[])
	{
		BetGame b=new BetGame();
		b.setTitle("My Bet Game");
		b.setSize(1000,700);
		b.setVisible(true);
		b.setBackground(Color.white);
		Font f=new Font(Font.DIALOG,1,12);
		b.setFont(f);
	}
	public void actionPerformed(ActionEvent ae) 
	{
		if(b1==ae.getSource())
		{
			String s=t1.getText();
			int f=Integer.parseInt(s);
			int ff=f*2;
			s=Integer.toString(ff);
			t1.setText(s);
		}
		if(b2==ae.getSource())
		{
			String s=t1.getText();
			int f=Integer.parseInt(s);
			int ff=f;
			if(f>=20)
			{
				ff=f/2;
			} 
			s=Integer.toString(ff);
			t1.setText(s);
		}
		if(bh==ae.getSource())
		{
			Random r=new Random();
			int n=r.nextInt(1000)+1;
			String s="generated number was: "+n;
			ln.setText(s);
			float a_bal=Float.parseFloat(tb.getText());
			float b_bal=Float.parseFloat(t1.getText())/100;
			if(c1==cbg.getSelectedCheckbox())
			{
				 if(n>=500)
					{
						float bal=a_bal+b_bal;
						String str=Float.toString(bal);
						tb.setText(str);
					}
					else
					{
						float bal=a_bal-b_bal;
						String str=Float.toString(bal);
						tb.setText(str);
					}
			}
			else if(c2==cbg.getSelectedCheckbox())
			{
				if(n<=490&&n>=501)
				{
					String s1=c2.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal+l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
				else
				{
					String s1=c2.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal-l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
			}
			else if(c3==cbg.getSelectedCheckbox())
			{
				if(n<=490&&n>=501)
				{
					String s1=c3.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal+l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
				else
				{
					String s1=c3.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal-l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
			}
			else if(c4==cbg.getSelectedCheckbox())
			{
				if(n<=490&&n>=501)
				{
					String s1=c4.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal+l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
				else
				{
					String s1=c4.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal-l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
			}
			else if(c5==cbg.getSelectedCheckbox())
			{
				if(n<=490&&n>=501)
				{
					String s1=c5.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal+l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
				else
				{
					String s1=c5.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal-l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
			}
		}
		if(bl==ae.getSource())
		{
			Random r=new Random();
			int n=r.nextInt(1000)+1;
			String s="generated number was: "+n;
			ln.setText(s);
			float a_bal=Float.parseFloat(tb.getText());
			float b_bal=Float.parseFloat(t1.getText())/100;
			if(c1==cbg.getSelectedCheckbox())
			{
				if(n<=500)
				{
					float bal=a_bal+b_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
				else
				{
					float bal=a_bal-b_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
			}
			else if(c2==cbg.getSelectedCheckbox())
			{
				if(n<=490&&n>=501)
				{
					String s1=c2.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal+l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
				else
				{
					String s1=c2.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal-l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
			}
			else if(c3==cbg.getSelectedCheckbox())
			{
				if(n<=490&&n>=501)
				{
					String s1=c3.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal+l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
				else
				{
					String s1=c3.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal-l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
			}
			else if(c4==cbg.getSelectedCheckbox())
			{
				if(n<=490&&n>=501)
				{
					String s1=c4.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal+l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
				else
				{
					String s1=c4.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal-l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
			}
			else if(c5==cbg.getSelectedCheckbox())
			{
				if(n<=490&&n>=501)
				{
					String s1=c5.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal+l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
				else
				{
					String s1=c5.getLabel();
					float l_bal=Float.parseFloat(s1);
					float bal=a_bal-l_bal;
					String str=Float.toString(bal);
					tb.setText(str);
				}
			}
		}
	}
}
