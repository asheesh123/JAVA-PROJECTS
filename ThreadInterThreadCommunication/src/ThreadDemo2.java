class MyThread2 extends Thread
{
	int total=0;
	public void run()
	{
		synchronized (this)
		{
			System.out.println("child thread starts calculation");
			for(int i=1;i<=100;i++)
			{
				total+=i;
			}
			System.out.println("calculated...giving notification");
			this.notify();
		}
	}
}
public class ThreadDemo2 
{
	public static void main(String[] args) throws InterruptedException 
	{
		MyThread2 t=new MyThread2();
		t.start();
		synchronized (t)
		{
			System.out.println("main thread calling wait() method");
			t.wait();
			System.out.println("main thread got notification");
			System.out.println("sum of first 100 natural numbers="+t.total);
		}
	}
}
