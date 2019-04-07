class MyThread4 extends Thread
{
	public void start()
	{
		super.start();
		System.out.println("start() method");
	
	}
	public void run()
	{
		System.out.println("run() method");
	}
}

public class ThreadDemo3
{
	public static void main(String[] args) 
	{
		MyThread4 t=new MyThread4();
		t.start();
		System.out.println("main() method");
	}
}
