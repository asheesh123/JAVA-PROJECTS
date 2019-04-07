import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
public class EmployeeAddress extends Frame implements ActionListener
{
	Button b1,b2,b3,b4,b5,b6,b7,b8;
	TextField t1,t2,t3,t4;
	Label l1,l2,l3,l4;
	int ci;
	ArrayList<EmployeeDetail> Emp;
	Label lw;
	public EmployeeAddress() 
	{
		setLayout(null);
		b1=new Button("ADD");
		b2=new Button("FIRST");
		b3=new Button("PRIVIOUS");
		b4=new Button("NEXT");
		b5=new Button("LAST");
		b6=new Button("MODIFY");
		b7=new Button("DELETE");
		b8=new Button("CLEAR");
		lw=new Label();
		l1=new Label("Name:");
		l2=new Label("Id:");
		l3=new Label("Address:");
		l4=new Label("Salary:");
		
		t1=new TextField(100);
		t2=new TextField(100);
		t3=new TextField(100);
		t4=new TextField(100);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		
		l1.setBounds(100,100,100,50);
		l2.setBounds(100,160,100,50);
		l3.setBounds(100,220,100,50);
		l4.setBounds(100,280,100,50);
		
		t1.setBounds(210,100,450,50);
		t2.setBounds(210,160,450,50);
		t3.setBounds(210,220,450,50);
		t4.setBounds(210,280,450,50);
		
		b1.setBounds(100,350,90,40);
		b2.setBounds(200,350,120,40);
		b3.setBounds(330,350,150,40);
		b4.setBounds(490,350,120,40);
		b5.setBounds(620,350,100,40);
		b6.setBounds(300,400,120,40);
		b7.setBounds(430,400,100,40);
		b8.setBounds(550,470,100,50);
		lw.setBounds(100,470,300,50);
		add(l1);add(l2);add(l3);add(l4);
		add(t1);add(t2);add(t3);add(t4);
		add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);add(lw);
		
		b1.setBackground(Color.cyan);
		b2.setBackground(Color.cyan);
		b3.setBackground(Color.cyan);
		b4.setBackground(Color.cyan);
		b5.setBackground(Color.cyan);
		b6.setBackground(Color.cyan);
		b7.setBackground(Color.cyan);
		b8.setBackground(Color.red);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		
		Emp=new ArrayList<EmployeeDetail>();
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		ci=-1;
		try
		{
			fis=new FileInputStream("Employee.txt");
		}
		catch(Exception e) {}
		try
		{
			ois=new ObjectInputStream(fis);
		}
		catch(Exception e) {}
		
		EmployeeDetail ed1;
		try
		{
			while((Emp=(ArrayList<EmployeeDetail>)ois.readObject())!=null )
			{}
		}
		catch(Exception e) {}
		finally
		{
			try
			{
				ois.close();
			}
			catch(Exception e) {}
		}
	}
	public static void main(String[] args) 
	{
		EmployeeAddress a=new EmployeeAddress();
		a.setVisible(true);
		a.setTitle("Employee Address Book");
		a.setBackground(Color.magenta);
		Toolkit t=a.getToolkit();
		Dimension d=t.getScreenSize();
		a.setSize(d.width,d.height);
		a.setFont(new Font(Font.DIALOG,Font.BOLD,20));
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(b1==ae.getSource())
		{
			EmployeeDetail ed=new EmployeeDetail();
			if((!t1.getText().equals("") && !t2.getText().equals("") && !t3.getText().equals("") &&!t4.getText().equals("")))
			{
				ed.name=t1.getText();
				ed.id=t2.getText();
				ed.addr=t3.getText();
				ed.sal=t4.getText();
				lw.setText("added");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				Emp.add(ed);
				ci=Emp.size()-1;
				FileOutputStream fos=null;
				try
				{
					fos=new FileOutputStream("Employee.txt");
				}
				catch(Exception e) {}
				ObjectOutputStream oos=null;
				try
				{
					oos=new ObjectOutputStream(fos);
				}
				catch(Exception e) {}
				try
				{
					oos.writeObject(Emp);
				}
				catch(Exception e) {}
				finally
				{
					try
					{
						oos.close();
					}
					catch(Exception e) {}
				}
			}
			else
			{
				lw.setText("first fill the fields..");
			}
		}
		if(b2==ae.getSource())
		{
			if(Emp.size()>=0)
			{
				ci=0;
				t1.setText(Emp.get(0).name);
				t2.setText(Emp.get(0).id);
				t3.setText(Emp.get(0).addr);
				t4.setText(Emp.get(0).sal);
				lw.setText("this is the first record");
			}
			else
			{
				lw.setText("no first record exists");
			}
			
		}
		if(b3==ae.getSource())
		{
			if(ci>0)
			{
				t1.setText(Emp.get(ci-1).name);
				t2.setText(Emp.get(ci-1).id);
				t3.setText(Emp.get(ci-1).addr);
				t4.setText(Emp.get(ci-1).sal);
				int show=ci;
				lw.setText("this is the "+show+" st record");
				ci--;
			}
			else
			{
				ci--;
				lw.setText("no more previous records");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			}
		}
		if(b4==ae.getSource())
		{
			
			if(ci<Emp.size()-1)
			{
				t1.setText(Emp.get(ci+1).name);
				t2.setText(Emp.get(ci+1).id);
				t3.setText(Emp.get(ci+1).addr);
				t4.setText(Emp.get(ci+1).sal);
				ci++;
				int show=ci+1;
				lw.setText("this is the "+show+" st record");
			}
			else
			{
				lw.setText("no more next records");
				ci++;
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			}
		}
		if(b5==ae.getSource())
		{
			if(ci>=0)
			{
				int s=Emp.size();
				t1.setText(Emp.get(s-1).name);
				t2.setText(Emp.get(s-1).id);
				t3.setText(Emp.get(s-1).addr);
				t4.setText(Emp.get(s-1).sal);
				ci=s-1;
				lw.setText("this is the last record");
			}
			else
			{
				lw.setText("no last record exists");
			}
			
		}
		if(b6==ae.getSource())
		{
			if(ci>=0&&ci<Emp.size())
			{
				EmployeeDetail ed=new EmployeeDetail();
				ed.name=t1.getText();
				ed.id=t2.getText();
				ed.addr=t3.getText();
				ed.sal=t4.getText();
				Emp.add(ci,ed);
				Emp.remove(ci+1);
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				lw.setText("modified");
				FileOutputStream fos=null;
				try
				{
					fos=new FileOutputStream("Employee.txt");
				}
				catch(Exception e) {}
				ObjectOutputStream oos=null;
				try
				{
					oos=new ObjectOutputStream(fos);
				}
				catch(Exception e) {}
				try
				{
					oos.writeObject(Emp);
				}
				catch(Exception e) {}
				finally
				{
					try
					{
						oos.close();
					}
					catch(Exception e) {}
				}
			}
			else
			{
				lw.setText("no such record to modify");
			}
		}
		if(b7==ae.getSource())
		{
			if(ci>=0&& ci<Emp.size())
			{
				lw.setText("deleted");
				Emp.remove(ci);
				ci--;
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				FileOutputStream fos=null;
				try
				{
					fos=new FileOutputStream("Employee.txt");
				}
				catch(Exception e) {}
				ObjectOutputStream oos=null;
				try
				{
					oos=new ObjectOutputStream(fos);
				}
				catch(Exception e) {}
				try
				{
					oos.writeObject(Emp);
				}
				catch(Exception e) {}
				finally
				{
					try
					{
						oos.close();
					}
					catch(Exception e) {}
				}
			}
			else
			{
				lw.setText("no such record to delete");
			}
		}
		if(b8==ae.getSource())
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			lw.setText("cleared..");
		}
	}
}

class EmployeeDetail implements Serializable 
{
	String name,id,sal,addr;
}
