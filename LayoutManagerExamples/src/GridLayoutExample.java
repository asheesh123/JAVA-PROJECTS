import java.awt.*;
import java.awt.event.*;
public class GridLayoutExample extends Frame 
{
	TextField t;
	public GridLayoutExample() 
	{
		t=new TextField("hi");
		setLayout(new GridLayout(10,10,10,10));
		add(t);

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		for(int i=1;i<100;i++)
		{
			add(new Button(""+i));
		}
	}
	public static void main(String[] args) 
	{
		GridLayoutExample g=new GridLayoutExample();
		g.setSize(1000,700);
		g.setVisible(true);
		g.setTitle("Grid Layout Example");
		g.setFont(new  Font(Font.DIALOG,Font.BOLD,20));
	}

}
