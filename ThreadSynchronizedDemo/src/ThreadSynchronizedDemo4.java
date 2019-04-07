
class Display4
{
	public void greet(String name)
	{
		;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;//huge lines of code
		synchronized (this)//object level locked synchronized block
		{
			for(int i=0;i<10;i++)
			{
				System.out.print("Hello:");
				try 
				{
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) 
				{}
				System.out.println(name);
			}
		}
		;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;//huge lines of code
	}
}
class MyThread6 extends Thread
{
	Display4 d;
	String name;
	public MyThread6(Display4 d,String name)
	{
		this.d=d;
		this.name=name;
	}
	public void run()
	{
		d.greet(name);
	}
}
public class ThreadSynchronizedDemo4
{
	public static void main(String[] args)
	{
		Display4 d=new Display4();
		MyThread6 t1=new MyThread6(d,"ravi");
		MyThread6 t2=new MyThread6(d,"ram");
		t1.start();
		t2.start();
	}
}
