import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ListExample {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List li=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            int x=sc.nextInt();
            li.add(x);
        }
       
    }
}
