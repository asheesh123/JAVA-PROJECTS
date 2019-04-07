import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
public class Page3 extends Frame implements ActionListener 
{
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
	Choice c1,c2,c3;
	TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
	CheckboxGroup cbg,cbg1;
	Checkbox cb1,cb11,cb2,cb22;
	Button b1;
	public Page3() 
	{
		setLayout(null);
		l1=new Label("Fees Category:");
		l2=new Label("Name of Student:");
		l3=new Label("Category of Student:");
		l4=new Label("Special Category PWD:");
		l5=new Label("Gender:");
		l6=new Label("Branch:");
		l7=new Label("Roll Number:");
		l8=new Label("Mobile Number of Student:");
		l9=new Label("Mobile Number of Parent:");
		l10=new Label("Email Id of Student:");
		l11=new Label("Email Id of Parent:");
		l12=new Label("Address - 1:");
		l13=new Label("Address - 2:");
		l14=new Label("Pin Code:");
		l15=new Label("Hostel Room Charges:");
		l16=new Label("Mess Charges:");
		l17=new Label("Remarks:");
		c1=new Choice();
		c2=new Choice();
		c3=new Choice();
		t1=new TextField(100);
		t2=new TextField(100);
		t3=new TextField(100);
		t4=new TextField(100);
		t5=new TextField(100);
		t6=new TextField(100);
		t7=new TextField(100);
		t8=new TextField(100);
		t9=new TextField(100);
		t10=new TextField(100);
		t11=new TextField(100);
		t12=new TextField(100);
		cbg=new CheckboxGroup();
		cbg1=new CheckboxGroup();
		cb1=new Checkbox("Yes",false,cbg);
		cb11=new Checkbox("No",false,cbg);
		cb2=new Checkbox("Male",false,cbg1);
		cb22=new Checkbox("Female",false,cbg1);
		b1=new Button("Submit");
		
		c1.add("I B.Tech I SEM 2017-18 HOSTEL FEE");
		c1.add("I B.Tech II SEM 2017-18 HOSTEL FEE");
		c1.add("II B.Tech I SEM 2017-18 HOSTEL FEE");
		c1.add("II B.Tech II SEM 2017-18 HOSTEL FEE");
		c1.add("III B.Tech I SEM 2017-18 HOSTEL FEE");
		c1.add("III B.Tech II SEM 2017-18 HOSTEL FEE");
		
		c2.add("OBC");
		c2.add("SC");
		c2.add("GEN");
		c2.add("ST");
		
		c3.add("CSE");
		c3.add("EEE");
		c3.add("ECE");
		c3.add("MECH");
		c3.add("CIVIL");
		c3.add("BI-TECH");
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(l11);
		add(l12);
		add(l13);
		add(l14);
		add(l15);
		add(l16);
		add(l17);
		add(c1);
		add(t1);
		add(c2);
		add(cb1);
		add(cb11);
		add(cb2);
		add(cb22);
		add(c3);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(t7);
		add(t8);
		add(t9);
		add(t10);
		add(t11);
		add(t12);
		add(b1);
		l1.setBounds(100,30,400,30);
		l2.setBounds(100,70,400,30);
		l3.setBounds(100,110,400,30);
		l4.setBounds(100,150,400,30);
		l5.setBounds(100,190,400,30);
		l6.setBounds(100,230,400,30);
		l7.setBounds(100,270,400,30);
		l8.setBounds(100,310,400,30);
		l9.setBounds(100,350,400,30);
		l10.setBounds(100,390,400,30);
		l11.setBounds(100,430,400,30);
		l12.setBounds(100,470,400,30);
		l13.setBounds(100,510,400,30);
		l14.setBounds(100,550,400,30);
		l15.setBounds(100,590,400,30);
		l16.setBounds(100,630,400,30);
		l17.setBounds(100,670,400,30);
		
		c1.setBounds(550,33,420,25);
		t1.setBounds(550,70,300,30);
		
		c2.setBounds(550,110,150,30);
		cb1.setBounds(550,150,100,30);
		cb11.setBounds(760,150,100,30);
		cb2.setBounds(550,190,100,30);
		cb22.setBounds(760,190,100,30);
		c3.setBounds(550,230,150,30);
		t2.setBounds(550,270,300,30);
		t3.setBounds(550,310,300,30);
		t4.setBounds(550,350,300,30);
		t5.setBounds(550,390,300,30);
		t6.setBounds(550,430,300,30);
		t7.setBounds(550,470,300,30);
		t8.setBounds(550,510,300,30);
		t9.setBounds(550,550,300,30);
		t10.setBounds(550,590,300,30);
		t11.setBounds(550,630,300,30);
		t12.setBounds(550,670,300,30);
		b1.setBounds(900,600,150,50);
		b1.setBackground(Color.cyan);
		b1.addActionListener(this);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				setVisible(false);
			}
		});
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(b1==ae.getSource())
		{
			FileDialog fd=new FileDialog(this,"save dialog",FileDialog.SAVE);
			fd.setVisible(true);
			String path,s=null;
			try 
			{
				path=fd.getDirectory()+fd.getFile();
				FileWriter fw=new FileWriter(path);
				s="Catogery                        "+c1.getSelectedItem()+"\n";
				s=s+"Name of the student           "+t1.getText()+"\n";
				s=s+"Catogery of the student       "+c2.getSelectedItem()+"\n";
				s=s+"Special Category PWD          "+cbg.getSelectedCheckbox().getLabel()+"\n";
				s=s+"Gender                        "+cbg1.getSelectedCheckbox().getLabel()+"\n";
				s=s+"Branch                        "+c3.getSelectedItem()+"\n";
				s=s+"Roll Number                   "+t2.getText()+"\n";
				s=s+"Mobile Number of Student      "+t3.getText()+"\n";
				s=s+"Mobile Number of Parent       "+t4.getText()+"\n";
				s=s+"Email Id of Student           "+t5.getText()+"\n";
				s=s+"Email Id of Parent            "+t6.getText()+"\n";
				s=s+"Address - 1                   "+t7.getText()+"\n";
				s=s+"Address - 2                   "+t8.getText()+"\n";
				s=s+"Pin Code                      "+t9.getText()+"\n";
				s=s+"Hostel Room Charges           "+t10.getText()+"\n";
				s=s+"Mess Charges                  "+t11.getText()+"\n";
				s=s+"Remarks                       "+t12.getText()+"\n";
				System.out.println(s);
				fw.write(s);
				fw.close();
			} 
			catch (Exception e) {}
		}
	}
}
