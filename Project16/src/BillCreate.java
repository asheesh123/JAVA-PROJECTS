import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class BillCreate extends Frame implements FocusListener
{
	Label l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,la;
	TextField t1,t11,t2,t22,t3,t33,t4,t44,t5,t55,t6,t66,t7,t77,t8,t88,t9,t99,t10,t1010,ta;
	int price[]={20,13,45,23,65,30,12,10,20,40};
	int total[]=new int[10];
	
	public BillCreate() 
	{
		setLayout(null);
		l=new Label("Item                                Quantity                           Amount");
		la=new Label("Total Amount:");
		l1=new Label("Apple:");
		t1=new TextField(50);
		t11=new TextField(50);
		l2=new Label("Banana:");
		t2=new TextField(50);
		ta=new TextField(50);
		t22=new TextField(50);
		l3=new Label("Cherry:");
		t3=new TextField(50);
		t33=new TextField(50);
		l4=new Label("Blackberry:");
		t4=new TextField(50);
		t44=new TextField(50);
		l5=new Label("Orange:");
		t5=new TextField(50);
		t55=new TextField(50);
		l6=new Label("Papaya:");
		t6=new TextField(50);
		t66=new TextField(50);
		l7=new Label("Mango:");
		t7=new TextField(50);
		t77=new TextField(50);
		l8=new Label("Pineapple:");
		t8=new TextField(50);
		t88=new TextField(50);
		l9=new Label("Pear:");
		t9=new TextField(50);
		t99=new TextField(50);
		l10=new Label("Guava:");
		t10=new TextField(50);
		t1010=new TextField(50);
		add(l);
		add(l1);add(t1);add(t11);
		add(l2);add(t2);add(t22);
		add(l3);add(t3);add(t33);
		add(l4);add(t4);add(t44);
		add(l5);add(t5);add(t55);
		add(l6);add(t6);add(t66);
		add(l7);add(t7);add(t77);
		add(l8);add(t8);add(t88);
		add(l9);add(t9);add(t99);
		add(l10);add(t10);add(t1010);
		add(la);add(ta);

		l.setBounds(100,50,600,40);
		l1.setBounds(100,100,70,30);
		l2.setBounds(100,140,70,30);
		l3.setBounds(100,180,70,30);
		l4.setBounds(100,220,70,30);
		l5.setBounds(100,260,70,30);
		l6.setBounds(100,300,70,30);
		l7.setBounds(100,340,70,30);
		l8.setBounds(100,380,70,30);
		l9.setBounds(100,420,70,30);
		l10.setBounds(100,460,70,30);
		la.setBounds(100,500,100,30);
		t1.setBounds(250,100,70,30);
		t2.setBounds(250,140,70,30);
		t3.setBounds(250,180,70,30);
		t4.setBounds(250,220,70,30);
		t5.setBounds(250,260,70,30);
		t6.setBounds(250,300,70,30);
		t7.setBounds(250,340,70,30);
		t8.setBounds(250,380,70,30);
		t9.setBounds(250,420,70,30);
		t10.setBounds(250,460,70,30);
		
		t11.setBounds(390,100,110,30);
		t22.setBounds(390,140,110,30);
		t33.setBounds(390,180,110,30);
		t44.setBounds(390,220,110,30);
		t55.setBounds(390,260,110,30);
		t66.setBounds(390,300,110,30);
		t77.setBounds(390,340,110,30);
		t88.setBounds(390,380,110,30);
		t99.setBounds(390,420,110,30);
		t1010.setBounds(390,460,110,30);
		ta.setBounds(390,500,110,30);
		t11.setEditable(false);
		t22.setEditable(false);
		t33.setEditable(false);
		t44.setEditable(false);
		t55.setEditable(false);
		t66.setEditable(false);
		t77.setEditable(false);
		t88.setEditable(false);
		t99.setEditable(false);
		ta.setEditable(false);
		t1010.setEditable(false);
		t1.addFocusListener(this);
		t2.addFocusListener(this);
		t3.addFocusListener(this);
		t4.addFocusListener(this);
		t5.addFocusListener(this);
		t6.addFocusListener(this);
		t7.addFocusListener(this);
		t8.addFocusListener(this);
		t9.addFocusListener(this);
		t10.addFocusListener(this);
		t1010.addFocusListener(this);
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
		BillCreate bl=new BillCreate();
		bl.setTitle("Bill Creator..");
		bl.setVisible(true);
		bl.setSize(1200,800);
		bl.setBackground(Color.cyan);
	}
	
	public void focusGained(FocusEvent fe) 
	{
		System.out.println();
	}
	public void focusLost(FocusEvent fe) 
	{
		if(t1==fe.getSource())
		{
			String s=t1.getText();
			int a=Integer.parseInt(s);
			t11.setText(Integer.toString(a*price[0]));
			total[0]=a*price[0];
		}
		else if(t2==fe.getSource())
		{
			String s=t2.getText();
			int a=Integer.parseInt(s);
			t22.setText(Integer.toString(a*price[1]));
			total[1]=a*price[1];
		}
		else if(t3==fe.getSource())
		{
			String s=t3.getText();
			int a=Integer.parseInt(s);
			t33.setText(Integer.toString(a*price[2]));
			total[2]=a*price[2];
		}
		else if(t4==fe.getSource())
		{
			String s=t4.getText();
			int a=Integer.parseInt(s);
			t44.setText(Integer.toString(a*price[3]));
			total[3]=a*price[3];
		}
		else if(t5==fe.getSource())
		{
			String s=t5.getText();
			int a=Integer.parseInt(s);
			t55.setText(Integer.toString(a*price[4]));
			total[4]=a*price[4];
		}
		else if(t6==fe.getSource())
		{
			String s=t6.getText();
			int a=Integer.parseInt(s);
			t66.setText(Integer.toString(a*price[5]));
			total[5]=a*price[5];
		}
		else if(t7==fe.getSource())
		{
			String s=t7.getText();
			int a=Integer.parseInt(s);
			t77.setText(Integer.toString(a*price[6]));
			total[6]=a*price[6];
		}
		else if(t8==fe.getSource())
		{
			String s=t8.getText();
			int a=Integer.parseInt(s);
			t88.setText(Integer.toString(a*price[7]));
			total[7]=a*price[7];
		}
		else if(t9==fe.getSource())
		{
			String s=t9.getText();
			int a=Integer.parseInt(s);
			t99.setText(Integer.toString(a*price[8]));
			total[8]=a*price[8];
		}
		else if(t10==fe.getSource())
		{
			String s=t10.getText();
			int a=Integer.parseInt(s);
			t1010.setText(Integer.toString(a*price[9]));
			total[9]=a*price[9];
		}
		else if(t1010==fe.getSource())
		{
			int to=0;
			for(int i=0;i<10;i++)
			{
				to+=total[i];
			}
			ta.setText(Integer.toString(to));
		}
	}
}
