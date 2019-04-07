import java.math.BigInteger;
import java.util.Scanner;


public class BigIntegerExample {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        BigInteger bi1=new BigInteger(s1);
        BigInteger bi2=new BigInteger(s2);
        System.out.println("sum="+bi1.add(bi2));
        System.out.println("bitcount of bi1="+bi1.bitCount());
        System.out.println("bitlength of bi2="+bi2.bitLength());
        System.out.println("compare bi1 with bi2="+bi1.compareTo(bi2));
        System.out.println("bi1 is divide by bi2="+bi1.divide(bi2));
        System.out.println("bi1 mod bi2="+bi1.mod(bi2));
        System.out.println("bi1 minus bi2="+bi1.subtract(bi2));
        System.out.println("bi1 xor bi2="+bi1.xor(bi2));
        
    }
}
