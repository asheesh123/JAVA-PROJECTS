import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridBagExample1 extends Frame 
{
	Button b[];
	public GridBagExample1()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.ipadx=30;
		gbc.ipady=20;
		b=new Button[8];
		for(int i=0;i<8;i++)
		{
			int t=i+1;
			b[i]=new Button(""+t);
			b[i].setBackground(Color.red);
		}
		gbc.fill=GridBagConstraints.NONE;
		gbc.anchor=GridBagConstraints.NORTH;
		add(b[0],gbc);
		
		gbc.fill=GridBagConstraints.NONE;
		gbc.anchor=GridBagConstraints.SOUTH;
		add(b[1],gbc);
		
		gbc.fill=GridBagConstraints.NONE;
		gbc.anchor=GridBagConstraints.WEST;
		add(b[2],gbc);
		
		gbc.fill=GridBagConstraints.NONE;
		gbc.anchor=GridBagConstraints.EAST;
		add(b[3],gbc);
		
		gbc.fill=GridBagConstraints.NONE;
		gbc.anchor=GridBagConstraints.NORTHWEST;
		add(b[4],gbc);
		
		gbc.fill=GridBagConstraints.NONE;
		gbc.anchor=GridBagConstraints.NORTHEAST;
		add(b[5],gbc);
		
		gbc.fill=GridBagConstraints.NONE;
		gbc.anchor=GridBagConstraints.SOUTHWEST;
		add(b[6],gbc);
		
		gbc.fill=GridBagConstraints.NONE;
		gbc.anchor=GridBagConstraints.SOUTHEAST;
		add(b[7],gbc);
		
		
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
		GridBagExample1 g=new GridBagExample1();
		g.setTitle("My GridBagLayout");
		g.setBackground(Color.white);
		g.setVisible(true);
		Toolkit t=g.getToolkit();
		Dimension d= t.getScreenSize();
		g.setBounds(d.width/4,d.height/4,d.width/2,d.height/2);
	}

}
