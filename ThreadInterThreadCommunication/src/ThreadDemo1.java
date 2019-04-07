class MyThread1 extends Thread
{
	int total=0;
	public void run()
	{
		;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;//huge lines of code
		for(int i=1;i<=100;i++)
		{
			total+=i;
		}
		;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;//huge lines of code
	}
}
public class ThreadDemo1 {

	public static void main(String[] args) throws InterruptedException
	{
		MyThread1 t=new MyThread1();
		t.start();
		Thread b1=Thread.currentThread();
		Thread.sleep(1000);
		//Thread.sleep(1);
		//t.join();//one of these method will work for getting result as 5050 but methods are not proficient  
		System.out.println("sum of first 100 natural numbers="+t.total);//0<=number<=5050
	}
}
