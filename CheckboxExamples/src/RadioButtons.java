import java.awt.*;
import java.awt.event.*;
public class RadioButtons extends Frame implements ItemListener
{
	TextArea ta;
	Checkbox c1,c2;
	CheckboxGroup cbg;
	RadioButtons()
	{
		setLayout(null);
		ta=new TextArea("",20,200,1);
		cbg=new CheckboxGroup();
		c1=new Checkbox("Male",false,cbg);
		c2=new Checkbox("Female",false,cbg);
		add(c1);
		add(c2);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		add(ta);
		c1.setBackground(Color.cyan);
		c2.setBackground(Color.cyan);
		c1.setBounds(100,100,100,40);
		c2.setBounds(210,100,110,40);
		ta.setBounds(100,150,230,300);
		c1.addItemListener(this);
		c2.addItemListener(this);
	}
	public static void main(String[] args)
	{
		RadioButtons r=new RadioButtons();
		r.setSize(800,500);
		r.setVisible(true);
		r.setTitle("Checkbox Group");
	}
	public void itemStateChanged(ItemEvent ie)
	{
		if(c1==ie.getItemSelectable())
		{
			if(c1.getState())
			{
				ta.append(c1.getLabel()+"\n");
			}
		}
		if(c2==ie.getItemSelectable())
		{
			if(c2.getState())
			{
				ta.append(c2.getLabel()+"\n");
			}
		}
	}

}
