import java.awt.*;
import java.awt.event.*;

public class RemainingNumber extends Frame implements ActionListener 
{
	Label l1,l2,l3,l4,l5,lt,l0;
	TextField t1,t2,t3,t4,t5,tt;
	Button b;
	public RemainingNumber() 
	{
		setLayout(null);
		b=new Button("SHOW");
		l0=new Label("Fill total mark and marks in any 4 subjects and press SHOW");
		l1=new Label("Subject 1:");
		l2=new Label("Subject 2:");
		l3=new Label("Subject 3:");
		l4=new Label("Subject 4:");
		l5=new Label("Subject 5:");
		lt=new Label("Total:");
		t1=new TextField("100",40);
		t2=new TextField("100",40);
		t3=new TextField("100",40);
		t4=new TextField(40);
		t5=new TextField("100",40);
		tt=new TextField("500",40);
		l0.setBounds(100,100,500,30);
		lt.setBounds(100,140,100,30);
		tt.setBounds(200,140,250,30);
		l1.setBounds(100,180,100,30);
		t1.setBounds(200,180,250,30);
		l2.setBounds(100,220,100,30);
		t2.setBounds(200,220,250,30);
		l3.setBounds(100,260,100,30);
		t3.setBounds(200,260,250,30);
		l4.setBounds(100,300,100,30);
		t4.setBounds(200,300,250,30);
		l5.setBounds(100,340,100,30);
		t5.setBounds(200,340,250,30);
		b.setBounds(220,400,150,40);
		add(l0);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(lt);
		add(tt);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(b);
		b.addActionListener(this);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		
	}
	public static void main(String[] args)
	{
		RemainingNumber r=new RemainingNumber();
		r.setSize(800,500);
		r.setTitle("My Calculator");
		r.setVisible(true);
		r.setBackground(Color.white);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(b==ae.getSource())
		{
			String s=tt.getText();
			int total=Integer.parseInt(s);
			String s1=t1.getText();
			String s2=t2.getText();
			String s3=t3.getText();
			String s4=t4.getText();
			String s5=t5.getText();
			if(s1.equals(""))
			{
				int sub2=Integer.parseInt(s2);
				int sub3=Integer.parseInt(s3);
				int sub4=Integer.parseInt(s4);
				int sub5=Integer.parseInt(s5);
				int sub1=total-(sub2+sub3+sub4+sub5);
				s=Integer.toString(sub1);
				t1.setText(s);
			}
			if(s2.equals(""))
			{
				int sub1=Integer.parseInt(s1);
				int sub3=Integer.parseInt(s3);
				int sub4=Integer.parseInt(s4);
				int sub5=Integer.parseInt(s5);
				int sub2=total-(sub1+sub3+sub4+sub5);
				s=Integer.toString(sub2);
				t2.setText(s);
			}
			if(s3.equals(""))
			{
				int sub2=Integer.parseInt(s2);
				int sub1=Integer.parseInt(s1);
				int sub4=Integer.parseInt(s4);
				int sub5=Integer.parseInt(s5);
				int sub3=total-(sub2+sub1+sub4+sub5);
				s=Integer.toString(sub3);
				t3.setText(s);
			}
			if(s4.equals(""))
			{
				int sub2=Integer.parseInt(s2);
				int sub3=Integer.parseInt(s3);
				int sub1=Integer.parseInt(s1);
				int sub5=Integer.parseInt(s5);
				int sub4=total-(sub2+sub3+sub1+sub5);
				s=Integer.toString(sub4);
				t4.setText(s);
			}
			if(s5.equals(""))
			{
				int sub2=Integer.parseInt(s2);
				int sub3=Integer.parseInt(s3);
				int sub4=Integer.parseInt(s4);
				int sub1=Integer.parseInt(s1);
				int sub5=total-(sub2+sub3+sub4+sub1);
				s=Integer.toString(sub5);
				t5.setText(s);
			}
		}
	}

}
