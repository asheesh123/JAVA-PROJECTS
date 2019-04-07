
class MyThread extends Thread
{
	
}
public class ThreadDemo 
{
	public static void main(String[] args)
	{
		System.out.println("main thread:"+Thread.currentThread().isDaemon());//false
		//Thread.currentThread().setDaemon(true);RE exception-->IllegalThreadStateException
		MyThread t=new MyThread();
		System.out.println("child thread:"+t.isDaemon());
		t.setDaemon(true);
		System.out.println("after chaning status as Daemon");
		System.out.println("child thread:"+t.isDaemon());
	}
}
