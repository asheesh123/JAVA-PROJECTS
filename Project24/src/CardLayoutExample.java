import java.awt.event.*;
import java.awt.*;

public class CardLayoutExample extends  Frame implements ActionListener
{
	Panel p[],mp;
	CardLayout cd;
	Button bf,bl,bn,bp,b2,b3;
	TextField t[];
	Label l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	public CardLayoutExample() 
	{
		cd=new CardLayout();
		setLayout(null);
		bn=new Button("NEXT");
		bl=new Button("LAST");
		bp=new Button("PREVIOUS");
		bf=new Button("FIRST");
		bf.setBounds(90,620,100,50);
		bn.setBounds(200,620,100,50);
		bp.setBounds(310,620,100,50);
		bl.setBounds(420,620,100,50);
		
		bf.setBackground(Color.green);
		bn.setBackground(Color.green);
		bp.setBackground(Color.green);
		bl.setBackground(Color.green);
		bf.addActionListener(this);
		bp.addActionListener(this);
		bn.addActionListener(this);
		bl.addActionListener(this);
		
		p=new Panel[4];
		for(int i=0;i<4;i++)
		{
			p[i]=new Panel();
		}
		t=new TextField[20];
		for(int i=0;i<20;i++)
		{
			t[i]=new TextField(30);
			t[i].addActionListener(this);
		}
		//panel 0-->Temperature converter
		l=new Label("Temperature Converter");
		l1=new Label("Temprature(°C):");
		l2=new Label("Temprature(°F):");
		p[0].setLayout(null);
		p[0].add(l);
		p[0].add(l1);
		p[0].add(t[0]);
		p[0].add(l2);
		p[0].add(t[1]);
		l.setBounds(60,5,200,40);
		l1.setBounds(10,50,130,40);
		l2.setBounds(10,120,130,40);
		t[0].setBounds(150,50,130,40);
		t[1].setBounds(150,120,130,40);
		
		//panel 1-->Length Converter
		l4=new Label("Length(cm):");
		l5=new Label("Length(feet):");
		l3=new Label("Length Converter");
		p[1].setLayout(null);
		p[1].add(l3);
		p[1].add(l4);
		p[1].add(t[2]);
		p[1].add(l5);
		p[1].add(t[3]);
		l3.setBounds(60,5,200,40);
		l4.setBounds(10,50,130,40);
		l5.setBounds(10,120,130,40);
		t[2].setBounds(150,50,130,40);
		t[3].setBounds(150,120,130,40);
		
		//panel 2-->Money Converter
		l6=new Label("Money Converter");
		l7=new Label("Rs/-Dollar:");
		l8=new Label("Rupees:");
		l9=new Label("Dollars:");
		p[2].setLayout(null);
		p[2].add(l6);
		p[2].add(l7);
		p[2].add(t[4]);
		p[2].add(l8);
		p[2].add(t[5]);
		p[2].add(l9);
		p[2].add(t[6]);
		l6.setBounds(60,5,200,40);
		l7.setBounds(10,50,130,40);
		l8.setBounds(10,120,130,40);
		t[4].setBounds(150,50,130,40);
		t[5].setBounds(150,120,130,40);
		l9.setBounds(10,190,130,40);
		t[6].setBounds(150,190,130,40);
		
		//panel 3-->biggest of three numbers
		l10=new Label("Biggest number Founder");
		l11=new Label("Number 1:");
		l12=new Label("Number 2:");
		l13=new Label("Number 3:");
		l14=new Label("Biggest");
		b2=new Button("RESULT");
		p[3].setLayout(null);
		p[3].add(l10);
		p[3].add(l11);
		p[3].add(t[7]);
		p[3].add(l12);
		p[3].add(t[8]);
		p[3].add(l13);
		p[3].add(t[9]);
		p[3].add(b2);
		p[3].add(l14);
		p[3].add(t[10]);
	
		l10.setBounds(60,5,230,40);
		l11.setBounds(10,50,130,40);
		l12.setBounds(10,120,130,40);
		t[7].setBounds(150,50,130,40);
		t[8].setBounds(150,120,130,40);
		l13.setBounds(10,190,130,40);
		t[9].setBounds(150,190,130,40);
		l14.setBounds(10,260,130,40);
		t[10].setBounds(150,260,180,40);
		t[10].setEditable(false);
		b2.setBounds(80,350,100,50);
		b2.setBackground(Color.cyan);
		b2.addActionListener(this);
		mp=new Panel(cd);
		
		for(int i=0;i<4;i++)
		{
			mp.add(p[i]);
		}
		
		add(mp);
		add(bf);add(bl);add(bp);add(bn);
		
		p[0].setBackground(Color.red);
		p[1].setBackground(Color.green);
		p[2].setBackground(Color.cyan);
		p[3].setBackground(Color.green);
				
		mp.setBounds(100,100,400,500);
		
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
		CardLayoutExample cd=new CardLayoutExample();
		cd.setSize(600,700);
		cd.setVisible(true);
		cd.setTitle("My Cards");
		cd.setBackground(Color.white);
		cd.setFont(new Font(Font.DIALOG,Font.BOLD,15));
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(bn==ae.getSource())
		{
			cd.next(mp);
		}
		if(bf==ae.getSource())
		{
			cd.first(mp);
		}
		if(bp==ae.getSource())
		{
			cd.previous(mp);
		}
		if(bl==ae.getSource())
		{
			cd.last(mp);
		}
		if(b2==ae.getSource())
		{
			try
			{
				float a=Float.parseFloat(t[7].getText());
				float b=Float.parseFloat(t[8].getText());
				float c=Float.parseFloat(t[9].getText());
				float max=a;
				if(max<b)
					max=b;
				if(max<c)
					max=c;
				t[10].setText(Float.toString(max));
			}
			catch(Exception e) 
			{
				t[10].setText("non numeric field");
			}
			
		}
		if(t[0]==ae.getSource())
		{
			String s=t[0].getText();
			if(!s.equals(""))
			{
				float c=Float.parseFloat(s);
				float f=((float)9/5)*c+32;
				t[1].setText(Float.toString(f));
			}
			else
			{
				t[1].setText("");
			}
		}
		if(t[1]==ae.getSource())
		{
			String s=t[1].getText();
			if(!s.equals(""))
			{
				float f=Float.parseFloat(s);
				float c=((f-32)*5)/9;
				t[0].setText(Float.toString(c));
			}
			else
			{
				t[0].setText("");
			}	
		}
		if(t[2]==ae.getSource())
		{
			String s=t[2].getText();
			if(!s.equals(""))
			{
				float c=Float.parseFloat(s);
				float f=(1/30.48f)*c;
				t[3].setText(Float.toString(f));
			}
			else
			{
				t[3].setText("");
			}
		}
		if(t[3]==ae.getSource())
		{
			String s=t[3].getText();
			if(!s.equals(""))
			{
				float f=Float.parseFloat(s);
				float c=(30.48f)*f;
				t[2].setText(Float.toString(c));
			}
			else
			{
				t[2].setText("");
			}	
		}
		
		if(t[5]==ae.getSource())
		{
			String s=t[4].getText();
			String s1=t[5].getText();
			if(!s.equals("")&&!s1.equals(""))
			{
				float nor=Float.parseFloat(s);
				float r=Float.parseFloat(s1);
				float c=r/nor;
				t[6].setText(Float.toString(c));
			}
			else
			{
				t[6].setText("");
			}	
		}
		if(t[6]==ae.getSource())
		{
			String s=t[4].getText();
			String s1=t[6].getText();
			if(!s.equals("")&&!s1.equals(""))
			{
				float nor=Float.parseFloat(s);
				float d=Float.parseFloat(s1);
				float c=nor*d;
				t[5].setText(Float.toString(c));
			}
			else
			{
				t[5].setText("");
			}	
		}
	}
}
