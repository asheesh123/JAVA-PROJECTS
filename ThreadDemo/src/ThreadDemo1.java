class MyThread1 extends Thread
{
	public void run()
	{
		System.out.println("no argument run() method");
	}
	public void run(int x)
	{
		System.out.println("argumented run() method");
	}
}
class MyThread2 extends Thread
{
	
}
public class ThreadDemo1
{
	public static void main(String[] args)
	{
		MyThread1 t=new MyThread1();
		t.start();
	}
}
