
public class ThreadDemo 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println("main thread started..");
		Thread.currentThread().join();
		System.out.println("end of main thread");
	}
}
