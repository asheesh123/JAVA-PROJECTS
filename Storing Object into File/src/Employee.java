
import java.io.*;

public class Employee implements Serializable
{
	String name;
	int salary;
	void getdata() throws IOException
	{
		System.out.println("enter name:");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		name=br.readLine();
		System.out.println("enter salary:");
		salary=Integer.parseInt(br.readLine());
	}
	void display()
	{
		System.out.println("name:"+ name);
		System.out.println("salary="+ salary);
	}

}
