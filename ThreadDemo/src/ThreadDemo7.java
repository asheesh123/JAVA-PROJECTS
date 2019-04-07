class MyThread7 extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println("child thread:"+i);
		}
	}
}
public class ThreadDemo7 
{
	public static void main(String[] args)
	{
		MyThread7 t=new MyThread7();
		t.setPriority(1);
		//my system is not supporting priority constraint
		t.start();
		for(int i=1;i<=10;i++)
		{
			System.out.println("parent thread:"+i);
		}
	}

}
