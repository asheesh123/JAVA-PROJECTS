import java.io.*;
import java.util.*;
public class ArrayListFile {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ArrayList<Employee> l=new ArrayList<Employee> ();
		l.add(new Employee("asheesh","25000"));
		l.add(new Employee("Sumanth","30"));
		l.add(new Employee("Shiva","24000"));
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("File2.txt"));
		oos.writeObject(l);
		oos.close();
		ArrayList<Employee> l1=new ArrayList<Employee> ();
		l1=(ArrayList<Employee>) l.clone();
		for(Employee e:l1)
		{
			e.read();
		}
	}

}
