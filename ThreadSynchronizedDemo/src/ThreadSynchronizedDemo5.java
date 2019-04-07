
class Display5
{
	public void greet(String name)
	{
		;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;//huge lines of code
		synchronized (Display5.class)//class level locked synchronized block
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
class MyThread7 extends Thread
{
	Display5 d;
	String name;
	public MyThread7(Display5 d,String name)
	{
		this.d=d;
		this.name=name;
	}
	public void run()
	{
		d.greet(name);
	}
}
public class ThreadSynchronizedDemo5
{
	public static void main(String[] args)
	{
		Display5 d1=new Display5();
		Display5 d2=new Display5();
		MyThread7 t1=new MyThread7(d1,"ravi");
		MyThread7 t2=new MyThread7(d2,"ram");
		t1.start();
		t2.start();
	}
}

