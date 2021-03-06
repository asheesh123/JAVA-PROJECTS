import java.io.*;
import java.util.*;

public class StringSpliting 
{
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
	public static void main(String[] args) throws IOException
	{
		ArrayList<String> in=new ArrayList<String>(1);
		ArrayList<String> output=new ArrayList<String>(1);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("enter a infix expression:");
		String infix=br.readLine();
		int t=0;
		String s="";
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
		for(int i=0;i<in.size();i++)
		{
			System.out.print(in.get(i)+" ");
			
		}
		System.out.println();
		Stack<String> stack=new Stack<String>();
		for(int i=0;i<in.size();i++)
		{
			try
			{
				System.out.print(pref(in.get(i))+" ");
			}
			catch(Exception e)
			{
				System.out.print("null");
			}
		}
		System.out.println();
		for(int i=0;i<in.size();i++)
		{
			int a=pref(in.get(i));
			if(a==0)
			{
				output.add(in.get(i));
			}
			if(a==1)
			{
				if(stack.size()==0)
				{
					stack.push(in.get(i));
				}
				else
				{
					while(pref(stack.peek())>=1)
					{
						output.add(stack.pop());
					}
					stack.push(in.get(i));
				}
			}
			if(a==2)
			{
				if(stack.size()==0)
				{
					stack.push(in.get(i));
				}
				else
				{
					int k=-1;
					try
					{
						k=pref(stack.peek());
					}
					catch(Exception e)
					{
						System.out.print("");
					}
					while(k>=2)
					{
						output.add(stack.pop());
					}
					stack.push(in.get(i));
				}
			}
		}
		while(stack.size()!=0)
		{
			output.add(stack.pop());
		}
		System.out.println("postfix");
		for(int i=0;i<output.size();i++)
		{
			System.out.print(output.get(i)+" ");
		}
		System.out.println();
		Stack<Float> st=new Stack<Float>();
		for(int i=0;i<output.size();i++)
		{
			if(output.get(i).equals("+")||output.get(i).equals("-")||output.get(i).equals("*")||output.get(i).equals("/"))
			{
				String op=output.get(i);
				float op2=st.pop();
				float op1=st.pop();
				float res= calculation(op1,op,op2);
				st.push(res);
			}
			else
			{
				float val=Float.parseFloat(output.get(i));
				st.push(val);
			}
		}
		System.out.println("result="+st.peek());
	}

}
