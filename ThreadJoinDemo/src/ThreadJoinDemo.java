class MyThread extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println("child thread:"+i);
			try 
			{
				Thread.sleep(2000);
			} 
			catch (InterruptedException e) 
			{
				System.out.println("CHlid thread got interrupted");
			}
		}
	}
}
public class ThreadJoinDemo {

	public static void main(String[] args) throws InterruptedException
	{
		MyThread t=new MyThread();
		t.start();
		t.join();//here main thread will wait until completing child thread execution
		//t.join(1000);
		//t.join(1000,100);
		for(int i=1;i<=10;i++)
		{
			System.out.println("parent thread :"+i);
		}
	}
}
