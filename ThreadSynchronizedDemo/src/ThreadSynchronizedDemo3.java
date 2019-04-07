class Display3
{
	public static synchronized void displayn()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println(i);
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{}
		}
	}
	public static synchronized void displayc()
	{
		char ch='A';
		for(int i=1;i<=10;i++)
		{
			System.out.println(ch);
			ch++;
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{}
		}
	}
}
class MyThread4 extends Thread
{
	Display3 d;
	public MyThread4(Display3 d)
	{
		this.d=d;
	}
	public void run()
	{
		d.displayn();
	}
}
class MyThread5 extends Thread
{
	Display3 d;
	public MyThread5(Display3 d)
	{
		this.d=d;
	}
	public void run()
	{
		d.displayc();
	}
}
public class ThreadSynchronizedDemo3 
{
	public static void main(String[] args) 
	{
		Display3 d1=new Display3();
		Display3 d2=new Display3();
		MyThread4 t1=new MyThread4(d1);
		MyThread5 t2=new MyThread5(d2);
		t1.start();//class level lock
		t2.start();//here noth displayn() and displayc() methods should be static synchronized for regular output
	}
}