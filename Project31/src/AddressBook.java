import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

	public static void main(String[] args) throws Exception {
		
		ArrayList<Student> student=new ArrayList<Student>();
		int ci=-1;
		Scanner sc=new Scanner(System.in);
		ObjectInputStream ois=null;
		try{
			ois=new ObjectInputStream(new FileInputStream("Student.txt"));
		}
		catch(Exception e) {}
		try {
			Student st;
			while((st=(Student)ois.readObject())!=null){
				student.add(st);
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
		ci=student.size();
		while(true)
		{
			System.out.println("_______________________________");
			System.out.println("1. Add a record");
			System.out.println("2. First rerecord display");
			System.out.println("3. Next record");
			System.out.println("4. Previous record");
			System.out.println("5. Last record");
			System.out.println("_______________________________");
			System.out.print("Enter your choice:");	
			int choice=sc.nextInt();
			System.out.println("----->");
			switch(choice)
			{
				case 1:
					Student s=new Student();
					s.add();
					student.add(s);
					ci=student.size()-1;
					ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Student.txt"));
					for(int i=0;i<student.size();i++)
					{
						oos.writeObject(student.get(i));
					}
					oos.close();
					break;
				case 2:
					if(student.size()>0)
					{
						student.get(0).display();
						System.out.println("this is the first record");
						ci=0;
					}
					else
						System.out.println("there is no first record in file");
					break;
				case 3:
					if(student.size()>0&&ci<student.size()-1)
					{
						student.get(ci+1).display();
						ci++;
					}
					else
					{
						System.out.println("no more next records");
						ci++;
					}
					break;
				case 4:
					if(ci>0 && student.size()>0)
					{
						student.get(ci-1).display();
						ci--;
					}
					else
					{
						ci--;
						System.out.println("no more previous records");
					}
					break;
				case 5:
					if(student.size()>0)
					{
						int si=student.size();
						student.get(si-1).display();
						ci=si-1;
						System.out.println("this is the last record");
					}
					else
					{
						System.out.println("no last record exists");
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

class Student implements Serializable
{
	String name,street,city,state,pincode;
	void add() throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter details of student");
		System.out.print("Name:");
		name=br.readLine();
		System.out.print("Street:");
		street=br.readLine();
		System.out.print("City:");
		city=br.readLine();
		System.out.print("State:");
		state=br.readLine();
		System.out.print("Pincode:");
		pincode=br.readLine();
	}
	void display()
	{
		System.out.println("Name:"+name);
		System.out.println("Street:"+street);
		System.out.println("City:"+city);
		System.out.println("State:"+state);
		System.out.println("Pincode:"+pincode);
	}
}
