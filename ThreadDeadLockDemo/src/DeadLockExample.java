class A
{
	public synchronized void d1(B b)
	{
		System.out.println("thread1 starts execution of d1() method");
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{}
		System.out.println("thread1 trying to call B's last() method");
		b.last();
	}
	public synchronized void last()
	{
		System.out.println("Insise A this is last() method");
	}
}
class B
{
	public synchronized void d2(A a)
	{
		System.out.println("thread2 starts execution of d2() method");
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{}
		System.out.println("thread2 trying to call A's last() method");
		a.last();
	}
	public synchronized void last()
	{
		System.out.println("Insise B this is last() method");
	}
}
public class DeadLockExample extends Thread
{
	A a=new A();
	B b=new B();
	public void m1()
	{
		this.start();
		a.d1(b);//executed by main thread
	}
	public void run()
	{
		b.d2(a);//executed by child thread
	}
	public static void main(String[] args) 
	{
		DeadLockExample d=new DeadLockExample();
		d.m1();//if any of one last() method is not synchronized then dead lock will not happen
	}
}
