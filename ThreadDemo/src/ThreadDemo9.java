class MyThread9 extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println("child thread:"+i);
		}
	}
}
public class ThreadDemo9
{
	public static void main(String[] args) throws InterruptedException 
	{
		MyThread8 t=new MyThread8();
		t.start();
		System.out.println("suspending child thread");
		t.suspend();
		System.out.println("executing main thread");
		for(int i=1;i<=10;i++)
		{
			System.out.println("main thread:"+i);
			Thread.sleep(1000);			
		}
		System.out.println("resuming child thread");
		t.resume();
	}
}
