class MyThread6 extends Thread
{
	
}
public class ThreadDemo6
{
	public static void main(String[] args)
	{
		MyThread6 t=new MyThread6();
		System.out.println("current excuting thread:"+Thread.currentThread().getName());
		Thread.currentThread().setName("asheesh");
		System.out.println("current excuting thread:"+Thread.currentThread().getName());
		System.out.println("current excuting thred id:"+Thread.currentThread().getId());
		System.out.println("child thread id:"+t.getId());
		MyThread6 t1=new MyThread6();
		System.out.println("child thread2 id:"+t1.getId());
		MyThread6 t2=new MyThread6();
		System.out.println("child thread2 id:"+t2.getId());
		System.out.println("child thread name:"+t.getName());
		System.out.println("child thread name:"+t1.getName());
		System.out.println("child thread name:"+t2.getName());
		System.out.println("current excuting thread:"+Thread.currentThread().getName());
		t.setName("pappu");
		System.out.println("first child thread new name is:"+t.getName());
		System.out.println("current executing thread priority:"+Thread.currentThread().getPriority());
		System.out.println("child1 priority:"+t.getPriority());
		System.out.println("child2 priority:"+t1.getPriority());
		System.out.println("child3 priority:"+t2.getPriority());
		Thread.currentThread().setPriority(7);
		System.out.println("after setting priority of main thread as 7");
		System.out.println("current executing thread priority:"+Thread.currentThread().getPriority());
		System.out.println("child1 priority:"+t.getPriority());
		System.out.println("child2 priority:"+t1.getPriority());
		System.out.println("child3 priority:"+t2.getPriority());
		MyThread6 t3=new MyThread6();
		System.out.println("child4 priority:"+t3.getPriority());
	}
}
