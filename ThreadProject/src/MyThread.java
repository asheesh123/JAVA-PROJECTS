import java.lang.*;
class MultiThread implements Runnable
{
	String str;
	public MultiThread(String str) {
				this.str=str;
	}
	public void run()
	{
		for(int i=0;i<=10;i++)
		{
			System.out.println(str+":"+i);
			try
			{
				Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
		}
	}
	
}
public class MyThread {
		public static void main(String[] args) {
		MultiThread ob1=new MultiThread("thread1");
		MultiThread ob2=new MultiThread("thread2");
		Thread t1=new Thread(ob1);
		Thread t2=new Thread(ob2);
		t1.start();
		t2.start();

	}

}
