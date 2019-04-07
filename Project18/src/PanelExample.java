import java.awt.*;
import java.awt.event.*;
public class PanelExample extends Frame implements ActionListener
{

	Panel p1,p2;
	Button b1,b2,ba,bs;
	TextField t1,t2,tr,t11,t22,trr;
	Label l1,l2,lr,l11,l22,lrr;
	public PanelExample() 
	{
		setLayout(null);
		p1=new Panel();
		p2=new Panel();
		b1=new Button("ADD");
		b2=new Button("SUB");
		ba=new Button("ADDITION");
		bs=new Button("SUBTRACTION");
		t1=new TextField(32);
		t2=new TextField(32);
		tr=new TextField(32);
		t11=new TextField(32);
		t22=new TextField(32);
		trr=new TextField(32);
		l1=new Label("Number1  :");
		l2=new Label("Number2  :");
		lr=new Label("Result    :");
		l11=new Label("Number1  :");
		l22=new Label("Number2  :");
		lrr=new Label("Result    :");
		p1.setLayout(null);
		p2.setLayout(null);
		add(ba);add(bs);
		add(p1);add(p2);
		b1.setSize(250,50);
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p1.add(lr);
		p1.add(tr);
		p1.add(b1);
		p2.add(l11);
		p2.add(t11);
		p2.add(l22);
		p2.add(t22);
		p2.add(lrr);
		p2.add(trr);
		p2.add(b2);
		ba.setBounds(100,100,200,50);
		bs.setBounds(310,100,200,50);
		p1.setBounds(100,160,410,300);
		p2.setBounds(100,160,410,300);
		p1.setVisible(false);
		p2.setVisible(false);
		
		l1.setBounds(30,30,100,40);
		l2.setBounds(30,90,100,40);
		lr.setBounds(30,150,100,40);
		
		t1.setBounds(150,30,250,40);
		t2.setBounds(150,90,250,40);
		tr.setBounds(150,150,250,40);
		
		b1.setBounds(80,220,100,40);
		
		l11.setBounds(30,30,100,40);
		l22.setBounds(30,90,100,40);
		lrr.setBounds(30,150,100,40);
		
		t11.setBounds(150,30,250,40);
		t22.setBounds(150,90,250,40);
		trr.setBounds(150,150,250,40);
		
		b2.setBounds(80,220,100,40);
		
		p1.setBackground(Color.cyan);
		p2.setBackground(Color.magenta);
		b1.addActionListener(this);
		b2.addActionListener(this);
		ba.addActionListener(this);
		bs.addActionListener(this);
		ba.setBackground(Color.cyan);
		bs.setBackground(Color.magenta);
		b1.setBackground(Color.green);
		b2.setBackground(Color.green);
		tr.setEditable(false);
		trr.setEditable(false);
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
		PanelExample p= new PanelExample();
		p.setVisible(true);
		p.setTitle("My Panel");
		p.setSize(800,700);
		p.setBackground(Color.white);
		Font f=new Font(Font.DIALOG,1,15);
		p.setFont(f);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ba==ae.getSource())
		{
			p1.setVisible(true);
			p2.setVisible(false);
			t1.setText("");
			t2.setText("");
			tr.setText("");
		}
		if(bs==ae.getSource())
		{
			p2.setVisible(true);
			p1.setVisible(false);
			t11.setText("");
			t22.setText("");
			trr.setText("");
		}
		if(b1==ae.getSource())
		{
			try
			{
				float f1=Float.parseFloat(t1.getText());
				float f2=Float.parseFloat(t2.getText());
				tr.setText(Float.toString(f1+f2));
			}
			catch(Exception e)
			{
				tr.setText("   not addable");
			}
		}
		if(b2==ae.getSource())
		{
			try
			{
				float f1=Float.parseFloat(t11.getText());
				float f2=Float.parseFloat(t22.getText());
				trr.setText(Float.toString(f1-f2));
			}
			catch(Exception e)
			{
				trr.setText("  not subtractable");
			}
		}
	}
}
