import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class TestGridBag extends Frame
{
	Button b1,b2,b3,b4,b5,b6;
	public TestGridBag()
	{
		setLayout(new GridBagLayout());
		
		GridBagConstraints cons= new GridBagConstraints();
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 1; 
		cons.gridheight = 2;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.anchor =  GridBagConstraints.SOUTH;
		cons.weightx = 1;
		cons.weighty = 2;
		cons.ipadx=30;
		cons.ipady=30;
		b1=new Button("Button1");
		add(b1,cons);
		
		cons.gridx = 1;
		cons.gridy = 0;
		cons.gridwidth = 1; 
		cons.gridheight = 3;
		cons.fill = GridBagConstraints.VERTICAL;
		cons.anchor =  GridBagConstraints.EAST;
		cons.weightx = 1;
		cons.weighty = 2;
		b2=new Button("Button2");
		add(b2,cons);
		
		cons.gridx = 2;
		cons.gridy = 0;
		cons.gridwidth = 2; 
		cons.gridheight = 2;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.anchor =  GridBagConstraints.NORTH;
		cons.weightx = 2;
		cons.weighty = 2;
		b3=new Button("Button3");
		add(b3,cons);
		
		cons.gridx = 0;
		cons.gridy = 2;
		cons.gridwidth = 1; 
		cons.gridheight = 1;
		cons.fill = GridBagConstraints.BOTH;
		cons.anchor =  GridBagConstraints.CENTER;
		cons.weightx = 1;
		cons.weighty = 1;
		b4=new Button("Button4");
		add(b4,cons);
		
		cons.gridx = 1;
		cons.gridy = 2;
		cons.gridwidth = 1; 
		cons.gridheight = 1;
		cons.fill = GridBagConstraints.NONE;
		cons.anchor =  GridBagConstraints.SOUTHWEST;
		cons.weightx = 1;
		cons.weighty = 1;
		b5=new Button("Button5");
		add(b5,cons);
		
		cons.gridx = 2;
		cons.gridy = 2;
		cons.gridwidth = 1; 
		cons.gridheight = 1;
		cons.fill = GridBagConstraints.BOTH;
		cons.anchor =  GridBagConstraints.CENTER;
		cons.weightx = 2;
		cons.weighty = 1;
		b6=new Button("Button6");
		add(b6,cons);
		
		b1.setBackground(Color.red);
		b2.setBackground(Color.red);
		b3.setBackground(Color.red);
		b4.setBackground(Color.red);
		b5.setBackground(Color.red);
		b6.setBackground(Color.red);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	public static void main(String args[])
	{
		TestGridBag t=new TestGridBag();
		t.setSize(1350,700);
		t.setVisible(true);
		t.setTitle("My GridBag Layout");
		t.setBackground(Color.white);
		Toolkit tk = t.getToolkit();
		Dimension d = tk.getScreenSize();
		t.setBounds(d.width/4, d.height/4,d.width/2, d.height/2);
	}
}
