import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class DayDifferenceExample {
	
	int dateDifference(Date d1,Date d2){
		long l1=d1.getTime();
		long l2=d2.getTime();
		if(l2>l1)
			return (int)((l2-l1)/(1000*60*60*24));
		else
			return (int)((l1-l2)/(1000*60*60*24));
	}

	public static void main(String[] args) {
		DayDifferenceExample dd=new DayDifferenceExample();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter first date(dd/mm/yyyy):");
		String s1=sc.next();
		System.out.print("Enter second date(dd/mm/yyyy):");
		String s2=sc.next();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		try{
			Date d1=sdf.parse(s1);
			Date d2=sdf.parse(s2);
			int d=dd.dateDifference(d1,d2);
			System.out.println("Difference between dates="+d);
		} 
		catch (ParseException e) {
			System.out.println("error in date format");
		}
		

	}
}
