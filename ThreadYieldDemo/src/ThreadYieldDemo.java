class MyThread extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println("child thread :"+i);
			Thread.yield();//some systems won't  provide proper support for yield() method  
		}
	}
}
public class ThreadYieldDemo {

	public static void main(String[] args) 
	{
		MyThread t=new MyThread();
		t.start();
		for(int i=1;i<=10;i++)
		{
			System.out.println("main thread :"+i);
		}
	}
}
