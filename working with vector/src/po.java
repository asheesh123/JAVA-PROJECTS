import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class po {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream oos=new ObjectInputStream(new FileInputStream("File2.txt"));
		ArrayList<Employee> l=(ArrayList<Employee>)oos.readObject();
		System.out.println(l.get(0).name);
		oos.close();
		
	}

}
