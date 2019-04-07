class Display2
{
	public synchronized void displayn()
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
	public synchronized void displayc()
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
class MyThread2 extends Thread
{
	Display2 d;
	public MyThread2(Display2 d)
	{
		this.d=d;
	}
	public void run()
	{
		d.displayn();
	}
}
class MyThread3 extends Thread
{
	Display2 d;
	public MyThread3(Display2 d)
	{
		this.d=d;
	}
	public void run()
	{
		d.displayc();
	}
}
public class ThreadSynchronizedDemo2 
{
	public static void main(String[] args) 
	{
		Display2 d=new Display2();
		MyThread2 t1=new MyThread2(d);
		MyThread3 t2=new MyThread3(d);
		t1.start();//object level lock
		t2.start();//here noth displayn() and displayc() methods should be synchronized for regular output
	}
}
