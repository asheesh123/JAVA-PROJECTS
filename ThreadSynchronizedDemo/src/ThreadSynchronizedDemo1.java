
class Display1
{
	public static synchronized void greet(String name)//this method should be static synchronized for regular output
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
}
class MyThread1 extends Thread
{
	Display1 d;
	String name;
	public MyThread1(Display1 d,String name)
	{
		this.d=d;
		this.name=name;
	}
	public void run()
	{
		d.greet(name);
	}
}
public class ThreadSynchronizedDemo1 
{
	public static void main(String[] args) 
	{
		Display1 d1=new Display1();
		Display1 d2=new Display1();
		MyThread1 t1=new MyThread1(d1,"ravi");
		MyThread1 t2=new MyThread1(d2,"ram");
		t1.start();
		t2.start();//class level lock
	}
}
