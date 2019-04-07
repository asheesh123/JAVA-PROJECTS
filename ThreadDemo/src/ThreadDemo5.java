class MyThread5 extends Thread
{
	public void run()
	{
		System.out.println("child thread");
	}
}
public class ThreadDemo5 
{
	public static void main(String[] args) throws InterruptedException
	{
		MyThread5 t=new MyThread5();
		Thread t1=new Thread(t);
		t1.start();
		//Thread.sleep(1);
		System.out.println("parent thread");
	}
}
