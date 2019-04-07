import java.awt.*;
import java.awt.event.*;
public class GridBagExample extends Frame
{
	Button b1,b2,b3,b4,b5;
	GridBagConstraints gbc;
	public GridBagExample() 
	{
		setLayout(new GridBagLayout());
		gbc=new GridBagConstraints();
		b1=new Button("Button1");
		
		gbc.gridx=0;
		gbc.gridy=0;
		//gbc.anchor=GridBagConstraints.NORTH;
		gbc.ipadx=50;
		gbc.ipady=20;
		gbc.gridheight=5;
		//gbc.insets=new Insets(15,15,15,15);
		gbc.fill=GridBagConstraints.VERTICAL;
		add(b1,gbc);
		
		b2=new Button("Button2");
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridheight=1;
		add(b2,gbc);
		
		b3=new Button("Button3");
		gbc.gridx=2;
		gbc.gridy=2;
		gbc.gridheight=1;
		add(b3,gbc);
		
		b4=new Button("Button4");
		gbc.gridx=3;
		gbc.gridy=3;
		gbc.gridheight=1;
		add(b4,gbc);
		
		b5=new Button("Button5");
		gbc.gridx=1;
		gbc.gridy=4;
		gbc.gridwidth=3;
		gbc.gridheight=1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(b5,gbc);
		b1.setBackground(Color.red);
		b2.setBackground(Color.red);
		b3.setBackground(Color.red);
		b4.setBackground(Color.red);
		b5.setBackground(Color.red);
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
		GridBagExample g=new GridBagExample();
		g.setSize(1350,700);
		g.setVisible(true);
		g.setTitle("My GridBag Layout");
		g.setBackground(Color.white);
		g.setFont(new Font(Font.DIALOG,Font.BOLD,20));
	}
}
