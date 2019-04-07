
class Display
{
	public synchronized void greet(String name) //if this method is not synchronized then irregular output will come
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
class MyThread extends Thread
{
	Display d;
	String name;
	public MyThread(Display d,String name)
	{
		this.d=d;
		this.name=name;
	}
	public void run()
	{
		d.greet(name);
	}
}
public class ThreadSynchronizedDemo 
{
	public static void main(String[] args) 
	{
		Display d=new Display();
		MyThread t1=new MyThread(d,"ravi");
		MyThread t2=new MyThread(d,"ram");
		t1.start();
		t2.start();//object level lock
	}
}
