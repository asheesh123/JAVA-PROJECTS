import java.io.*;
import java.text.ParseException;
import java.util.*;
public class EmployeeFile
{
	public static void main(String[] args) throws IOException, ParseException 
	{
		Employee emp=new Employee();
		RandomAccessFile raf=new RandomAccessFile("employee.txt", "rw");
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("1.add employee.");
			System.out.println("2.Modify employee.");
			System.out.println("3.Display employee.");
			System.out.println("4.Top 5 employees based on experience.");
			System.out.println("5.Top 5 employees based on salary.");
			System.out.println("6.Exit");
			System.out.print("enter your choice:");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:
					emp.get_detail();
					emp.show_detail();
					String buf=emp.ename+"|"+emp.empid+"|"+emp.esal+emp.dob+"|"+emp.doj+"|"+emp.eadd;
					raf.writeChars(buf);
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					choice=6;
					break;
			}
			if(choice==6)
			{
				System.out.println("exiting...");
				break;
			}
		}
		raf.close();
	}
}
