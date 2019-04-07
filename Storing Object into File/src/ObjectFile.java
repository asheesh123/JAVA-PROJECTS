import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
public class ObjectFile 
{

	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		ArrayList<Employee > emp=new ArrayList<Employee>();
		Employee eee=new Employee();
		FileInputStream fis=new FileInputStream("employee.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		try
		{
			while((eee=(Employee)ois.readObject())!=null)
			{
				emp.add(eee);
				eee.display();
			}
		}
		catch(EOFException e)
		{
			System.out.println("now nothing is there in  file");
		}
		ois.close();
		FileOutputStream fos=new FileOutputStream("employee.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		System.out.print("enter number of employee records to add into file:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		for(int i=0;i<n;i++)
		{
			Employee ee=new Employee();
			ee.getdata();
			emp.add(ee);
		}
		System.out.print(emp.size());
		for(int i=0;i<emp.size();i++)
		{
			emp.get(i).display();
			oos.writeObject(emp.get(i));
		}
		oos.flush();
		oos.close();
	}
}
