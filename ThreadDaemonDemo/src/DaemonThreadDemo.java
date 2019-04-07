
class MyThread1 extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println("child thread:"+i);
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{}
		}
	}
}
public class DaemonThreadDemo 
{
	public static void main(String[] args)
	{
		MyThread1 t=new MyThread1();
		//t.setDaemon(true);//if this line will be commented then child thread is also nun-daemon thread so it can complete its execution else will be terminated with main thread   
		t.start();
		System.out.println("end of main thread");
	}
}
