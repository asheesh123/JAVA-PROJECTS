class ThreadA extends Thread
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
public class ThreadWaitDemo {

	public static void main(String[] args) {
		ThreadA t=new ThreadA();
		t.start();
		System.out.println("sum of first 100 natural numbers="+t.total);

	}

}
