import java.util.*;
import java.io.*;
public class RandomIntegersFile
{

	public static void main(String[] args) throws IOException
	{
		Random r=new Random();
		FileWriter fw = new FileWriter("Integer.txt");
		for(int i=0;i<100;i++)
		{
			int n=r.nextInt();
			 
			fw.write(n+"\n");
		}
		fw.close();
	}
	
}
