
public class ThreadJoinDemo2 
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("Hi Asheesh");
		Thread.currentThread().join();//its kind of dead lock here main thread is waiting for itself
		System.out.println("Hello");
	}
}
