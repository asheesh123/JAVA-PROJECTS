import java.awt.*;
import java.awt.event.*;
public class PanelExampleCopyPaste extends Frame implements ActionListener 
{
	Panel p1,p2;
	Button b1;
	TextField t1,t2;
	public PanelExampleCopyPaste()
	{
		setLayout(null);
		p1=new Panel();
		p2=new Panel();
		b1=new Button("COPY");
		t1=new TextField(10);
		t2=new TextField(10);
		add(p1);
		add(p2);
		p1.add(t1);
		p1.add(b1);
		p2.add(t2);
		p1.setBackground(Color.cyan);
		p2.setBackground(Color.cyan);
		p1.setLayout(null);
		p2.setLayout(null);
		
		p1.setBounds(100,100,300,300);
		p2.setBounds(410,100,300,300);
		t1.setBounds(10,10,280,40);
		b1.setBounds(80,80,90,40);
		
		t2.setBounds(10,10,280,40);
		b1.addActionListener(this);
		b1.setBackground(Color.green);
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
		PanelExampleCopyPaste p=new PanelExampleCopyPaste();
		p.setSize(800,700);
		p.setVisible(true);
		p.setTitle("My Panel");
		p.setBackground(Color.black);
		Font f=new Font(Font.DIALOG,1,20);
		p.setFont(f);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(b1==ae.getSource())
		{
			t2.setText(t1.getText());
		}
	}
}
