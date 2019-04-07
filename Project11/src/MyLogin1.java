import java.awt.*;
import java.awt.event.*;
public class MyLogin1 extends Frame implements ActionListener 
{
	Label l1,l2;
	TextField t1,t2,t;
	Button b1,b2;
	public MyLogin1()
	{
		setLayout(null);
		t=new TextField(200);
		t1=new TextField(100);
		t2=new TextField(100);
		l1=new Label("userid:");
		l2=new Label("password:");
		b1=new Button("login");
		b2=new Button("cancel");
		t.setBounds(100,100,300,30);
		l1.setBounds(100,140,70,30);
		t1.setBounds(170,140,230,30);
		l2.setBounds(100,180,70,30);
		t2.setBounds(170,180,230,30);
		b1.setBounds(100,230,150,40);
		b2.setBounds(250,230,150,40);
		t2.setEchoChar('*');
		t.setVisible(false);
		add(t);
		add(t1);
		add(l1);
		add(l2);
		add(t2);
		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
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
		MyLogin1 ml=new MyLogin1();
		ml.setSize(800, 500);
		ml.setTitle("My Login");
		ml.setVisible(true);
		ml.setBackground(Color.cyan);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(b1==ae.getSource())
		{
			t.setVisible(true);
			String s1=t1.getText();
			String s2=t2.getText();
			if((s1.equals("asheesh")&&s2.equals("asheesh"))||(s1.equals("12345")&&s2.equals("12345"))||(s1.equals("ram")&&s2.equals("ram")))
			{
				t.setText("you are logged in successfuly!");
			}
			else
				t.setText("sorry! userid or password is wrong");
		}
		if(b2==ae.getSource())
		{
			t1.setText("");
			t2.setText("");
			t.setText("");
			t.setVisible(false);
		}
	}
}

