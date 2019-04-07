import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.Stack;
public class CalculatorSci extends Frame implements ActionListener
{
	Panel cf;
	TextArea ta,ta1;
	Button btns[];
	Label l;
	static int pref(String x)
	{
		if(x.equals("+")||x.equals("-"))
			return 1;
		else if(x.equals("*")||x.equals("/"))
			return 2;
		else if(x.equals("^"))
			return 3;
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
		else if(x.equals("^"))
		{
			System.out.println("power");
			
			float res=(float) Math.pow(op1,op2);
			return res;
		}
		else 
		{
			float res=(op1/op2);
			return res;
		}
	}
	public CalculatorSci() 
	{
		setLayout(null);
		cf=new Panel(new GridLayout(6,4,10,10));
		ta=new TextArea("",1,400,3);
		ta1=new TextArea("",1,400,3);
		l=new Label("This is a basic calculator");
		btns=new Button[24];
		for(int i=0;i<24;i++)
			btns[i]=new Button();
		ta.setBounds(200,100,400,50);
		ta1.setBounds(200,150,400,50);
		cf.setBounds(200,200,400,400);
		l.setBounds(200,50,400,40);
		cf.setBackground(Color.cyan);
		l.setBackground(Color.CYAN);
		add(l);
		add(ta1);
		add(ta);
		add(cf);
		btns[0].setLabel("CLEAR");
		btns[1].setLabel("DEL");
		btns[2].setLabel("(");
		btns[3].setLabel(")");
		btns[4].setLabel("sin");
		btns[5].setLabel("cos");
		btns[6].setLabel("tan");
		btns[7].setLabel("^");
		btns[8].setLabel("7");
		btns[9].setLabel("8");
		btns[10].setLabel("9");
		btns[11].setLabel("/");
		btns[12].setLabel("4");
		btns[13].setLabel("5");
		btns[14].setLabel("6");
		btns[15].setLabel("*");
		btns[16].setLabel("1");
		btns[17].setLabel("2");
		btns[18].setLabel("3");
		btns[19].setLabel("-");
		btns[20].setLabel("0");
		btns[21].setLabel(".");
		btns[22].setLabel("=");
		btns[23].setLabel("+");
		for(int i=0;i<24;i++)
		{
			cf.add(btns[i]);
			btns[i].addActionListener(this);
			btns[i].setBackground(Color.magenta);
		}
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
		CalculatorSci c=new CalculatorSci();
		c.setSize(900,720);
		c.setVisible(true);
		c.setTitle("My Calculator");
		c.setFont(new Font(Font.DIALOG,Font.BOLD,20));
		c.setBackground(Color.gray);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btns[0])
		{
			ta.setText("");
		}
		else if(ae.getSource()==btns[1])
		{
			ta.setText(ta.getText().substring(0,ta.getText().length()-1));
		}
		else if(ae.getSource()==btns[22])
		{
			String infix=ta.getText();
			String s="";
			ArrayList<String> in=new ArrayList<String>(1);
			ArrayList<String> output=new ArrayList<String>(1);
			for(int i=0;i<infix.length();i++)
			{
				if(infix.charAt(i)!='+'&&infix.charAt(i)!='-'&&infix.charAt(i)!='*'&&infix.charAt(i)!='/'&&infix.charAt(i)!='%'&&infix.charAt(i)!='('&&infix.charAt(i)!=')'&&infix.charAt(i)!='^')
				{
					s+=infix.charAt(i);
				}
				else
				{
					if(!s.equals(""))
					in.add(s);
					in.add(infix.charAt(i)+"");
					s="";
				}
			}
			if(!s.equals(""))
			in.add(s);
			Stack<String> stack=new Stack<String>();
			for(int i=0;i<in.size();i++)
			{
				System.out.println(in.get(i)+"  ");
			}
			for(int i=0;i<in.size();i++)
			{
			
				int a=pref(in.get(i));
				if(in.get(i).equals("("))
					stack.push(in.get(i));
				else if(in.get(i).equals(")"))
				{
					while(!stack.peek().equals("("))
					{
						try
						{
							output.add(stack.pop());
						}
						catch(Exception e) {}
					}
					try 
					{
						stack.pop();
					}
					catch(Exception e) {}
				}
				if(a!=0)
				{
					if(stack.isEmpty())
					{
						stack.push(in.get(i));
					}
					else 
					{
						
						while(stack.size()>0&&pref(stack.peek())>=a &&stack.peek()!="(")
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
				if(!stack.peek().equals("("))
				output.add(stack.pop());
				else
					stack.pop();
			}
			for(int i=0;i<output.size();i++)
			{
				System.out.println(output.get(i));
			}
			Stack<Float> st1=new Stack<Float>();
			for(int i=0;i<output.size();i++)
			{
				if(output.get(i).equals("+")||output.get(i).equals("-")||output.get(i).equals("*")||output.get(i).equals("/")||output.get(i).equals("^"))
				{
					try
					{
						String op=output.get(i);
						float op2=st1.pop();
						float op1=st1.pop();
						float res= calculation(op1,op,op2);
						st1.push(res);
					}
					catch(Exception e) {}					
				}
				else
				{
					float val=Float.parseFloat(output.get(i));
					st1.push(val);
				}
			}
			ta1.append(infix+"="+Float.toString(st1.peek())+"\n");
			ta.setText(Float.toString(st1.peek()));
		}
		else
		{
			ta.append(ae.getActionCommand());
		}
	}
}
