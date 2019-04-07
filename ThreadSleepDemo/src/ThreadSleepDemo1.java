class MyThread1 extends Thread
{
	public void run()
	{
		for(int i=1;i<=1000;i++)
		{
			System.out.println("child thread: "+i);	
		}
		System.out.println("Child thread is going to sleep now");
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			System.out.println("Child thread got interrupted");
		}
	}
}
public class ThreadSleepDemo1
{

	public static void main(String[] args) 
	{
		MyThread1 t=new MyThread1();
		t.start();
		t.interrupt();
		System.out.println("End of main thread");
	}
}
