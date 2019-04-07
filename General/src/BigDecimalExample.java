import java.math.BigDecimal;
import java.util.Scanner;


public class BigDecimalExample {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		BigDecimal bd=new BigDecimal(s);
		s=bd.toString();
		System.out.println("you have entered:"+bd);
		int i[]=new int[10];
		i[0]=1;
		i[1]=2;
		i[2]=3;
		System.out.println(i.length);
		System.out.println("asheesh");
		
	}
}
