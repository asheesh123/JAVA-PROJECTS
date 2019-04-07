import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
public class BillCreate extends Frame implements ActionListener
{
	Label l1,l2,l3,l4,l5,l6,l7;
	List li1,li2;
	TextField t1,t2,t3,t4,t5;
	TextArea ta;
	int win=5000,kali=4000,mint=3000,ubuntu=3500,mon=12000,key=300,mouse=630,ups=2000,printer=2500;
	BillCreate()
	{
		setLayout(null);
		l1=new Label("S.No.");
		l2=new Label("Item");
		l3=new Label("Quantity");
		l4=new Label("Price");
		l5=new Label("1.");
		l6=new Label("2.");
		l7=new Label("Total:");
		li1=new List(4,true);
		li2=new List(4,true);
		t1=new TextField(50);
		t2=new TextField(50);
		t3=new TextField(50);
		t4=new TextField(50);
		t5=new TextField(50);
		ta=new TextArea("",10,200,2);
		li1.add("windows10");
		li1.add("kali");
		li1.add("mint");
		li1.add("ubuntu");
		
		li2.add("Monitor");
		li2.add("Keyboard");
		li2.add("Mouse");
		li2.add("UPS");
		li2.add("Printer");
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(li1);
		add(t1);
		add(t3);
		add(li2);
		add(t2);
		add(t4);
		add(t5);
		add(l7);
		t3.setEditable(false);
		t4.setEditable(false);
		t5.setEditable(false);
		l1.setBounds(150,100,100,40);
		l2.setBounds(300,100,200,40);
		l3.setBounds(510,100,150,40);
		l4.setBounds(670,100,150,40);
		
		l5.setBounds(150,150,100,100);
		li1.setBounds(300,150,200,100);
		t1.setBounds(510,170,150,40);
		t3.setBounds(670,170,150,40);
		
		l6.setBounds(150,260,100,100);
		li2.setBounds(300,260,200,100);
		t2.setBounds(510,280,150,40);
		t4.setBounds(670,280,150,40);
		
		l7.setBounds(150,370,200,40);
		t5.setBounds(520,370,300,40);
		
		t1.addActionListener(this);
		t2.addActionListener(this);
		t5.addActionListener(this);
		
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
		BillCreate b=new BillCreate();
		b.setVisible(true);
		b.setSize(1000,700);
		b.setTitle("Bill Create");
		b.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		b.setBackground(Color.pink);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(t1==ae.getSource())
		{
		    int[]  in=li1.getSelectedIndexes();
		    float price=0;
		    for(int i=0;i<4;i++)
	    	{
		    	try
			    {
			    	int a=in[i];
			    	int q=Integer.parseInt(t1.getText());
			    	switch(a)
			    	{
			    		case 0:
			    			price+=win*q;
			    			break;
			    		case 1:
			    			price+=kali*q;
			    			break;
			    		case 2:
			    			price+=mint*q;
			    			break;
			    		case 3:
			    			price+=ubuntu*q;
			    			break;
			    	}
			    }
		    	catch(Exception e)
			    {
		    		
			    }
	    	}
			t3.setText(Float.toString(price));
		}
		if(t2==ae.getSource())
		{
		    int[]  in=li2.getSelectedIndexes();
		    float price=0;
		    for(int i=0;i<5;i++)
	    	{
		    	try
			    {
			    	int a=in[i];
			    	int q=Integer.parseInt(t2.getText());
			    	switch(a)
			    	{
			    		case 0:
			    			price+=mon*q;
			    			break;
			    		case 1:
			    			price+=key*q;
			    			break;
			    		case 2:
			    			price+=mouse*q;
			    			break;
			    		case 3:
			    			price+=ups*q;
			    		case 4:
			    			price+=printer*q;
			    			break;
			    	}
			    }
		    	catch(Exception e)
			    {}
	    	}
			t4.setText(Float.toString(price));
		}
		if(t5==ae.getSource())
		{
			String s1=t3.getText();
			String s2=t4.getText();
			float a,b;
			try
			{
				a=Float.parseFloat(s1);
			}
			catch(Exception e)
			{
				a=0;
			}
			try
			{
				b=Float.parseFloat(s2);
			}
			catch(Exception e)
			{
				b=0;
			}
			t5.setText(Float.toString(a+b));
		}
			
	}	
}
