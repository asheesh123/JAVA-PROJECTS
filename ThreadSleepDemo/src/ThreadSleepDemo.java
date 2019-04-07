class MyThread extends Thread
{
	public void run()
	{
		try
		{
			for(int i=1;i<=10;i++)
			{
				System.out.println("child thread executing:"+i);
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{
			System.out.println("child thread got interrupted");
		}
	}
}
public class ThreadSleepDemo
{
	public static void main(String[] args) throws InterruptedException
	{
		MyThread t=new MyThread();
		t.start();
		t.interrupt();
		System.out.println("End of main thread");
	}
}
