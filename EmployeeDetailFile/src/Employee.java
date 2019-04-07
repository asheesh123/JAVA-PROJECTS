import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Employee 
{
	String ename;
	int empid;
	int esal;
	String eadd;
	Date doj;
	Date dob;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	void get_detail()throws IOException,ParseException
	{
		System.out.print("enter name:");
		ename=br.readLine();
		System.out.print("enter employee id:");
		empid=Integer.parseInt(br.readLine());
		System.out.print("enter employee salary:");
		esal=Integer.parseInt(br.readLine());
		System.out.print("enter employee address:");
		eadd=br.readLine();
		System.out.print("enter employee's joining date(dd/mm/yyyy):");
		String s=br.readLine();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		doj=sdf.parse(s);
		System.out.print("enter employee's date of birth(dd/mm/yyyy):");
		s=br.readLine();
		dob=sdf.parse(s);
	}
	void show_detail()
	{
		System.out.println("employee name:"+ename);
		System.out.println("employee id:"+empid);
		System.out.println("employee salary:"+esal);
		System.out.println("date of joining:"+doj);
		System.out.println("date of birth"+dob);
	}
	void add_emp()
	{
		System.out.println("hi");
	}
	void modify_emp()
	{
		System.out.println("hi");
	}
	void display_emp()
	{
		System.out.println("hi");
	}
	void top_5_emp_based_on_salary()
	{
		System.out.println("hi");
	}
	void top_5_emp_based_on_experience()
	{
		System.out.println("hi");
	}
}
