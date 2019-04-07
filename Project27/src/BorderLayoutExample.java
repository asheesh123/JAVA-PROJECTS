import java.awt.*;
import java.awt.event.*;
public class BorderLayoutExample extends Frame implements ActionListener 
{
	Button b1;
	TextArea ta1,ta2,ta3,ta4;
	public BorderLayoutExample()
	{
		setLayout(new BorderLayout(20,20));
		
		b1=new Button("Center");
		ta1=new TextArea("south",7,10,3);
		ta2=new TextArea("north",7,10,3);
		ta3=new TextArea("east",10,30,3);
		ta4=new TextArea("west",10,30,3);
		add(ta1,BorderLayout.SOUTH);
		add(ta2,BorderLayout.NORTH);
		add(ta3,BorderLayout.EAST);
		add(ta4,BorderLayout.WEST);
		
		add(b1,BorderLayout.CENTER);
		b1.setBackground(Color.cyan);
		b1.addActionListener(this);
		addWindowListener(new WindowAdapter()
		{
			public void  windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) 
	{
		BorderLayoutExample b=new BorderLayoutExample();
		b.setVisible(true);
		Toolkit t=b.getToolkit();
		Dimension d=t.getScreenSize();
		b.setSize(d.width,d.height);
		b.setBackground(Color.magenta);
		b.setFont(new Font(Font.DIALOG,Font.BOLD,20));
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(b1==ae.getSource())
		{
			String s1=ta1.getText();
			String s2=ta2.getText();
			String s3=ta3.getText();
			String s4=ta4.getText();
			ta1.setText(s2);
			ta2.setText(s3);
			ta3.setText(s4);
			ta4.setText(s1);
		}
	}
}
