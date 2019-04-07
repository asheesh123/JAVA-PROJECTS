class MyThread extends Thread
{
	int total=0;
	public void run()
	{
		for(int i=1;i<=100;i++)
		{
			total+=i;
		}
	}
}
public class ThreadDemo {

	public static void main(String[] args)
	{
		MyThread t=new MyThread();
		t.start();
		System.out.println("sum of first 100 natural numbers="+t.total);//0<=number<=5050
	}
}
