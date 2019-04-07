
public class InnerExample extends Test{
	
	void print1()//print()-->overriding not allowed for final methods
	{  
		System.out.println("hello");
	}
	public static void main(String args[])
	{
		
		InnerExample o=new InnerExample();
		o.print();
	}
}
class Test
{
	final void print()
	{
		System.out.println("hi");
	}
}
