class Reserve1 implements Runnable
{
	int available=1;
	int wanted;
	Reserve1(int i)
	{
		wanted=i;
	}
synchronized public void run()
	{
		
		System.out.println("available="+available);
		if(available>=wanted)
		{
			String name=Thread.currentThread().getName();
			System.out.println(wanted+"berths reserved for"+name);
			try
			{
				Thread.sleep(1500);
				available=available -wanted;
				
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
		}
		else
			System.out.println("sorry no berth is reserved");
	
	}
}
public class Mutex1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reserve1 ob=new Reserve1(1);
		Thread t1=new Thread(ob);
		Thread t2=new Thread(ob);
		t1.setName("first person");
		t2.setName("second person");
		t1.start();
		t2.start();

	}

}
