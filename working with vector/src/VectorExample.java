import java.util.Vector;


public class VectorExample 
{
	public static void main(String[] args) 
	{
		Vector<Integer> v = new Vector<Integer>();
		v.add(4);
		v.add(9);
		System.out.println("asheesh");
		for(int i:v)
		{
			System.out.println(i);
		}
		v.remove(0);
		for(int i:v)
		{
			System.out.println(i);
		}
	}

}
