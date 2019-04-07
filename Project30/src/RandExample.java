import java.io.*;
import java.util.*;
public class RandExample {

	public static void main(String[] args) {
	
		Random r=new Random();
		FileWriter fw=null;
		try {
			fw=new FileWriter("IntegersFile.txt");
			for(int i=0;i<100;i++){
				int n=r.nextInt();
				fw.write(n+"\n");
			}
		} 
		catch (IOException e) {
			System.out.println("File didn't open");
		}
		finally
		{
			try {
				fw.close();
			} 
			catch (IOException e) {
				
			}
		}
	}
}
