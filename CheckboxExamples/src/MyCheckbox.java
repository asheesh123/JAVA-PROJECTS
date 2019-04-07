import java.awt.*;
import java.awt.event.*;
public class MyCheckbox extends Frame implements ItemListener
{
	Checkbox c1,c2,c3,c4,c5;
	TextArea ta;
	public MyCheckbox() 
	{
		setLayout(null);
		c1=new Checkbox("computer");
		c2=new Checkbox("printer");
		c3=new Checkbox("mouse");
		c4=new Checkbox("key board");
		c5=new Checkbox("moniter");
		ta=new TextArea("",20,20,1);
		c1.setBounds(100,100,100,40);
		c2.setBounds(100,140,100,40);
		c3.setBounds(100,180,100,40);
		c4.setBounds(100,220,100,40);
		c5.setBounds(100,260,100,40);
		ta.setBounds(100,300,150,200);
		setBackground(Color.white);
		add(c1);add(c2);add(c3);add(c4);add(c5);add(ta);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		c4.addItemListener(this);
		c5.addItemListener(this);		
	}
	public static void main(String[] args)
	{
		MyCheckbox m=new MyCheckbox();
		m.setTitle("Checkbox Example");
		m.setSize(800,600);
		m.setVisible(true);
	}
	public void itemStateChanged(ItemEvent ie) 
	{
		if(c1==ie.getItemSelectable())
		{
			if(c1.getState())
			{
				String s=c1.getLabel();
				ta.append(s+"\n");
			}
		}
		if(c2==ie.getItemSelectable())
		{
			if(c2.getState())
			{
				String s=c2.getLabel();
				ta.append(s+"\n");
			}
		}
		if(c3==ie.getItemSelectable())
		{
			if(c3.getState())
			{
				String s=c3.getLabel();
				ta.append(s+"\n");
			}
		}
		if(c4==ie.getItemSelectable())
		{
			if(c4.getState())
			{
				String s=c4.getLabel();
				ta.append(s+"\n");
			}
		}
		if(c5==ie.getItemSelectable())
		{
			if(c5.getState())
			{
				String s=c5.getLabel();
				ta.append(s+"\n");
			}
		}
	}

}
