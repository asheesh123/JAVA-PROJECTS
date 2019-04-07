import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class EmployeeDetails {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		final ArrayList<Employee> emps=new ArrayList<Employee>();
		Scanner sc=new Scanner(System.in);
		ObjectInputStream ois=null;
		try{
			ois=new ObjectInputStream(new FileInputStream("Employee.txt"));
		}
		catch(Exception e) {}
		try {
			Employee em;
			while((em=(Employee)ois.readObject())!=null){
				emps.add(em);
			}
			ois.close();
		}
		catch(Exception e) {}
		finally {
			try {
				ois.close();
			}
			catch(Exception e) {}
		}
		while(true)
		{
			System.out.println("_______________________________");
			System.out.println("1. Add a Employee");
			System.out.println("2. Modify Employee details");
			System.out.println("3. Display all employees");
			System.out.println("4. Display top 5 employees based on experience");
			System.out.println("5. Display top 5 employees based on salary");
			System.out.println("_______________________________");
			System.out.print("Enter your choice:");	
			int choice=sc.nextInt();
			System.out.println("----->");
			Employee temp =new Employee();
			switch(choice)
			{
				case 1:
					Employee emp=new Employee();
					emp.addEmployee();
					emps.add(emp);
					ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Employee.txt"));
					for(int i=0;i<emps.size();i++)
					{
						oos.writeObject(emps.get(i));
					}
					oos.close();
					break;
				case 2:
					for(int i=0;i<emps.size();i++)
					{
						System.out.println(emps.get(i).ename+"   "+emps.get(i).eid);
					}
					System.out.print("enter Id of employee,you want to modify:");
					String id=br.readLine();
					int i;
					for(i=0;i<emps.size();i++)
					{
						if(emps.get(i).eid.equals(id))
							break;
					}
					if(i!=emps.size() && emps.size()>0)
					{
						temp=temp.modifyEmployee(emps.get(i));
						emps.add(temp);
						emps.remove(i+1);
						
						ObjectOutputStream oos1=new ObjectOutputStream(new FileOutputStream("Employee.txt"));
						for(int j=0;j<emps.size();j++)
						{
							oos1.writeObject(emps.get(j));
						}
						oos1.close();
					}
					else
					{
						System.out.println("no such Id found");
					}
					break;
				case 3:
					if(emps.size()>0)
						temp.displayEmployee(emps);
					else
						System.out.println("no details available");
					break;
				case 4:
					if(emps.size()>=5)
					{
						temp.top_5_Emp_Exp(emps);
					}
					else
					{
						System.out.println("add more employees so that atleast five employees should be there");
					}
					break;
				case 5:
					if(emps.size()>=5)
					{
						temp.top_5_Emp_Sal(emps);
					}
					else
					{
						System.out.println("add more employees so that atleast five employees should be there");
					}
					break;
				default:
					choice=6;
					break;
			}
			if(choice==6)
			{
				System.out.println("exiting...");
				break;
			}
		}
	}
}
class Employee implements Serializable
{
	String ename,eid;
	int esal;
	String addr;
	Date dob,doj;
	void addEmployee() throws IOException, ParseException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("enter details of employee");
		System.out.print("Name:");
		ename=br.readLine();
		System.out.print("Id of employee:");
		eid=br.readLine();
		System.out.print("Salary:");
		esal=Integer.parseInt(br.readLine());
		System.out.print("Enter address:");
		addr=br.readLine();
		System.out.print("Enter dob(dd/MM/yyyy):");
		String temp=br.readLine();
		dob=sdf.parse(temp);
		System.out.print("Enter doj(dd/MM/yyyy):");
		temp=br.readLine();
		doj=sdf.parse(temp);
	}
	Employee modifyEmployee(Employee emp) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		String ch;
		System.out.print("do you want to modify name(y/n):");
		ch=br.readLine();
		if(ch.equals("y"))
		{
			System.out.print("Enter new name:");
			emp.ename=br.readLine();
		}
		System.out.print("do you want to modify Id(y/n):");
		ch=br.readLine();
		if(ch.equals("y"))
		{
			System.out.print("Enter new Id:");
			emp.eid=br.readLine();
		}
		System.out.print("do you want to modify salary(y/n):");
		ch=br.readLine();
		if(ch.equals("y"))
		{
			System.out.print("Enter new salary:");
			emp.esal=Integer.parseInt(br.readLine());
		}
		System.out.print("do you want to modify address(y/n):");
		ch=br.readLine();
		if(ch.equals("y"))
		{
			System.out.print("Enter new Id:");
			emp.addr=br.readLine();
		}
		System.out.print("do you want to modify dob(y/n):");
		ch=br.readLine();
		if(ch.equals("y"))
		{
			System.out.print("Enter modified date of birth(dd/MM/yyyy):");
			String temp=br.readLine();
			emp.dob=sdf.parse(temp);
		}
		System.out.print("do you want to modify doj(y/n):");
		ch=br.readLine();
		if(ch.equals("y"))
		{
			System.out.print("Enter modified date of join(dd/MM/yyyy):");
			String temp=br.readLine();
			emp.doj=sdf.parse(temp);
		}
		return emp;
	}
	void displayEmployee(ArrayList<Employee> emps)
	{
		for(int i=0;i<emps.size();i++)
		{
			System.out.println("Name:"+emps.get(i).ename);
			System.out.println("Id:"+emps.get(i).eid);
			System.out.println("Salary:"+emps.get(i).esal);
			System.out.println("Address:"+emps.get(i).addr);
			String bdateToStr = DateFormat.getDateInstance().format(emps.get(i).dob); 
			System.out.println("Date of birth:"+bdateToStr);
			String jdateToStr = DateFormat.getDateInstance().format(emps.get(i).doj);
			System.out.println("Date of join:"+jdateToStr);
			System.out.println();
		}
	}
	void top_5_Emp_Sal(ArrayList<Employee> emps1)
	{
		ArrayList<Employee> emps=new ArrayList<Employee>();
		emps=(ArrayList<Employee>) emps1.clone();
		for(int i=0;i<emps.size();i++)
		{
			for(int j=0;j<emps.size();j++)
			{
				if(emps.get(i).esal>emps.get(j).esal)
				{
					Employee temp=emps.get(i);
					emps.add(i,emps.get(j));
					emps.remove(i+1);
					emps.add(j,temp);
					emps.remove(j+1);
				}
			}
		}
		for(int i=0;i<5;i++)
		{
			System.out.println("Name:"+emps.get(i).ename);
			System.out.println("Id:"+emps.get(i).eid);
			System.out.println("Salary:"+emps.get(i).esal);
			System.out.println("Address:"+emps.get(i).addr);
			String bdateToStr = DateFormat.getDateInstance().format(emps.get(i).dob); 
			System.out.println("Date of birth:"+bdateToStr);
			String jdateToStr = DateFormat.getDateInstance().format(emps.get(i).doj);
			System.out.println("Date of join:"+jdateToStr);
			System.out.println();
		}
	}
	void top_5_Emp_Exp(ArrayList<Employee> emps1)
	{
		ArrayList<Employee> emps=new ArrayList<Employee>();
		emps=(ArrayList<Employee>) emps1.clone();//clone() method will create new object that is same as object being cloned
		for(int i=0;i<emps.size();i++)
		{
			for(int j=0;j<emps.size();j++)
			{
				long doj1=emps.get(i).doj.getTime();
				long doj2=emps.get(j).doj.getTime();
				Date curdate=new Date();
				long cur=curdate.getTime();
				long e1=cur-doj1;
				long e2=cur-doj2;
				if(e1>e2)
				{
					Employee temp=emps.get(i);
					emps.add(i,emps.get(j));
					emps.remove(i+1);
					emps.add(j,temp);
					emps.remove(j+1);
				}
			}
		}
		for(int i=0;i<5;i++)
		{
			System.out.println("Name:"+emps.get(i).ename);
			System.out.println("Id:"+emps.get(i).eid);
			System.out.println("Salary:"+emps.get(i).esal);
			System.out.println("Address:"+emps.get(i).addr);
			String bdateToStr = DateFormat.getDateInstance().format(emps.get(i).dob); 
			System.out.println("Date of birth:"+bdateToStr);
			String jdateToStr = DateFormat.getDateInstance().format(emps.get(i).doj);
			System.out.println("Date of join:"+jdateToStr);
			System.out.println();
		}
	}
}
