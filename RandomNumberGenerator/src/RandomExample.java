import java.util.*;
public class RandomExample
{

	public static void main(String[] args) 
	{
		Random gen=new Random();
		int max=15,min=5;
		int range=max-min+1;
		for(int i=0;i<10;i++)
		{
			System.out.print(gen.nextInt(10)+range-min+" ");
		}
		System.out.println();
		for(int i=0;i<10;i++)
		{
			System.out.print((gen.nextDouble()*10)+" ");
		}
		System.out.println();
		for(int i=0;i<10;i++)
		{
			System.out.print(Math.round(Math.random()*10)+" ");
		}
	}

}
