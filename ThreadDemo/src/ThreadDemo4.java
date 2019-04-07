class MyRunnable implements Runnable
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("child thread "+(i+1));
		}
	}
}
public class ThreadDemo4 
{
	public static void main(String[] args) 
	{
		MyRunnable r=new MyRunnable();
		Thread t1=new Thread();
		Thread t2=new Thread(r);
		t1.start();
		t1.run();
		//t2.start();
		//t2.run();
		//r.start();
		r.run();
		for(int i=1;i<=10;i++)
		{
			System.out.println("main thread "+i);
		}	
	}
}
