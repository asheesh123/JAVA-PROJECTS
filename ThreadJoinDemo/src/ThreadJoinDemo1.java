class MyThread1 extends Thread
{
	static Thread mainthread;
	public void run()
	{
		try
		{
			mainthread.join();//here child thread will wait until completing main thread
			//mainthread.join(1000);
			//mainthread.join(1000,100);
		}
		catch(InterruptedException e)
		{}
		for(int i=1;i<=10;i++)
		{
			System.out.println("child thread :"+i);
		}
	}
}
public class ThreadJoinDemo1 {

	public static void main(String[] args) throws InterruptedException 
	{
		MyThread1.mainthread=Thread.currentThread();
		MyThread1 t=new MyThread1();
		t.start();
		for(int i=1;i<=10;i++)
		{
			System.out.println("main thread :"+i);
			Thread.sleep(2000);
		}
	}

}
