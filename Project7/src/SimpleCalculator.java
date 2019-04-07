import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Stack;
public class SimpleCalculator extends Frame implements ActionListener
{
	TextField t,t1;
	Label l;
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,bd,be,b0,bpo,bm,bs,bp,bc,bmo,bo,bcc;
	static int pref(String x)
	{
		if(x.equals("+")||x.equals("-"))
			return 1;
		else if(x.equals("*")||x.equals("/"))
			return 2;
		else 
			return 0;
	}
	static float calculation(float op1,String x,float op2)
	{
		if(x.equals("+"))
		{
			float res=(op1+op2);
			return res;
		}
		if(x.equals("-"))
		{
			float res=(op1-op2);
			return res;
		}
		if(x.equals("*"))
		{
			float res=(op1*op2);
			return res;
		}
		else
		{
			float res=(op1/op2);
			return res;
		}		
	}
	public SimpleCalculator() 
	{
		setLayout(null);
		l=new Label("Basic Calculator");
		t=new TextField(300);
		t1=new TextField(100);
		b1=new Button("1");
		b2=new Button("2");
		b3=new Button("3");
		bp=new Button("+");
		b4=new Button("4");
		b5=new Button("5");
		b6=new Button("6");
		bs=new Button("-");
		b7=new Button("7");
		b8=new Button("8");
		b9=new Button("9");
		bm=new Button("*");
		b0=new Button("0");
		bpo=new Button(".");
		be=new Button("=");
		bd=new Button("/");
		bc=new Button("CLEAR");
		bmo=new Button("DEL");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		bp.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		bs.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bm.addActionListener(this);
		b0.addActionListener(this);
		bpo.addActionListener(this);
		be.addActionListener(this);
		bd.addActionListener(this);
		bc.addActionListener(this);
		bmo.addActionListener(this);
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		l.setBounds(150,60,150,30);
		t.setBounds(100,100,150,30);
		t1.setBounds(250,100,50,30);
		b1.setBounds(100,140,50,30);
		b2.setBounds(150,140,50,30);
		b3.setBounds(200,140,50,30);
		bp.setBounds(250,140,50,30);
		b4.setBounds(100,180,50,30);
		b5.setBounds(150,180,50,30);
		b6.setBounds(200,180,50,30);
		bs.setBounds(250,180,50,30);
		b7.setBounds(100,220,50,30);
		b8.setBounds(150,220,50,30);
		b9.setBounds(200,220,50,30);
		bm.setBounds(250,220,50,30);
		b0.setBounds(100,260,50,30);
		bpo.setBounds(150,260,50,30);
		bmo.setBounds(200,260,50,30);
		bd.setBounds(250,260,50,30);
		bc.setBounds(100,300,100,30);
		be.setBounds(200,300,100,30);
		add(l);
		add(t);
		add(t1);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		add(b0);
		add(bs);
		add(bp);
		add(bpo);
		add(bd);
		add(bc);
		add(bm);
		add(be);
		add(bmo);
	}
	public static void main(String[] args) 
	{
		SimpleCalculator s=new SimpleCalculator();
		s.setSize(800,600);
		s.setVisible(true);
		s.setTitle("My Calculator");
		s.setBackground(Color.white);
	}

	public void actionPerformed(ActionEvent ae) 
	{
		String s1,s2,st;
		if(b1==ae.getSource())
		{
			s1=t.getText();
			s2=b1.getLabel();
			if(!s2.equals("="))
			{
				
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
			if(s1.charAt(s1.length()-1)=='+')
			{
				
			}
		}
		if(b2==ae.getSource())
		{
			s1=t.getText();
			s2=b2.getLabel();
			if(!s2.equals("="))
			{
				
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
		}
		if(b3==ae.getSource())
		{
			s1=t.getText();
			s2=b3.getLabel();
			if(!s2.equals("="))
			{
				
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
		}
		if(b4==ae.getSource())
		{
			s1=t.getText();
			s2=b4.getLabel();
			if(!s2.equals("="))
			{
				
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
		}
		if(b5==ae.getSource())
		{
			s1=t.getText();
			s2=b5.getLabel();
			if(!s2.equals("="))
			{
				
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
		}
		if(b6==ae.getSource())
		{
			s1=t.getText();
			s2=b6.getLabel();
			if(!s2.equals("="))
			{
				
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
		}
		if(b7==ae.getSource())
		{
			s1=t.getText();
			s2=b7.getLabel();
			if(!s2.equals("="))
			{
				
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
		}
		if(b8==ae.getSource())
		{
			s1=t.getText();
			s2=b8.getLabel();
			if(!s2.equals("="))
			{
				
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
		}
		if(b9==ae.getSource())
		{
			s1=t.getText();
			s2=b9.getLabel();
			if(!s2.equals("="))
			{
				
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
		}
		if(b0==ae.getSource())
		{
			s1=t.getText();
			s2=b0.getLabel();
			if(!s2.equals("="))
			{
				
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
		}
		if(bpo==ae.getSource())
		{
			s1=t.getText();
			s2=bpo.getLabel();
			if(!s2.equals("="))
			{
				
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
		}
		if(bp==ae.getSource())
		{
			s1=t.getText();
			s2=bp.getLabel();
			if(!s2.equals("="))
			{
				
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
		}
		if(bs==ae.getSource())
		{
			s1=t.getText();
			s2=bs.getLabel();
			if(!s2.equals("="))
			{
				
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
		}
		if(bm==ae.getSource())
		{
			s1=t.getText();
			s2=bm.getLabel();
			if(!s2.equals("="))
			{
				
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
		}
		if(bd==ae.getSource())
		{
			s1=t.getText();
			s2=bd.getLabel();
			if(!s2.equals("="))
			{
				
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
		}
		if(bmo==ae.getSource())
		{
			s1=t.getText();
			s2=bmo.getLabel();
			if(!s2.equals("="))
			{
				s1=s1+s2;
				t.setText(s1);
			}
			else
				t.setText(s1);
		}
		if(be==ae.getSource())
		{
			String infix=t.getText();
			int t=0;
			String s="";
			ArrayList<String> in=new ArrayList<String>(1);
			ArrayList<String> output=new ArrayList<String>(1);
			for(int i=0;i<infix.length();i++)
			{
				if(infix.charAt(i)!='+'&&infix.charAt(i)!='-'&&infix.charAt(i)!='*'&&infix.charAt(i)!='/'&&infix.charAt(i)!='%')
				{
					s+=infix.charAt(i);
				}
				else
				{
					in.add(s);
					in.add(infix.charAt(i)+"");
					s="";
				}
			}
			in.add(s);
			Stack<String> stack=new Stack<String>();
			
			for(int i=0;i<in.size();i++)
			{
				int a=pref(in.get(i));
				if(a!=0)
				{
					if(stack.isEmpty())
					{
						stack.push(in.get(i));
					}
					else 
					{
						
						while(stack.size()>0 && pref(stack.peek())>=a)
						{
								output.add(stack.pop());
						}
						stack.push(in.get(i));
					}
				}
				else
				{
					output.add(in.get(i));
				}
			}
			if(!stack.isEmpty())
			while(!stack.isEmpty())
			{
				output.add(stack.pop());
			}
			Stack<Float> st1=new Stack<Float>();
			for(int i=0;i<output.size();i++)
			{
				if(output.get(i).equals("+")||output.get(i).equals("-")||output.get(i).equals("*")||output.get(i).equals("/"))
				{
					String op=output.get(i);
					float op2=st1.pop();
					float op1=st1.pop();
					float res= calculation(op1,op,op2);
					st1.push(res);
				}
				else
				{
					float val=Float.parseFloat(output.get(i));
					st1.push(val);
				}
			}
			t1.setText(Float.toString(st1.peek()));
		}
		if(bc==ae.getSource())
		{
			t.setText("");
		}
	}
}
