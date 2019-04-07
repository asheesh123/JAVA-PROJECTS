class MyThread8 extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println("child thread:"+i);
		}
	}
}
public class ThreadDemo8 
{
	public static void main(String[] args) 
	{
		MyThread8 t=new MyThread8();
		t.start();
		System.out.println(" trying to stop child thread");
		t.stop();
	}
}
