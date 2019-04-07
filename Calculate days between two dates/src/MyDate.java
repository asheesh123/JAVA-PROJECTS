import java.io.*;
import java.util.*;
import java.text.*;
public class MyDate 
{
	int dateDifference(Date d1,Date d2)
	{
		long l1=d1.getTime();
		long l2=d2.getTime();
		int l=(int)((l1-l2)/86400000);
		return l;
	}

	public static void main(String[] args) throws IOException, ParseException 
	{
		System.out.print("enter first date(dd/mm/yyyy):");
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s1=br.readLine();
		System.out.print("enter second date(dd/mm/yyyy):");
		String s2=br.readLine();
		MyDate d=new MyDate();
		Date d1=sdf.parse(s1);
		Date d2=sdf.parse(s2);
		int diff=d.dateDifference(d1,d2);
		System.out.println("difference="+diff);
	}

}
