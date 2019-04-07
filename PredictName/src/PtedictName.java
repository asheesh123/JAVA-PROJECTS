import java.io.*;
import java.util.*;
public class PtedictName 
{
	public static void main(String[] args) 
	{
		int i,j;
		char[][] content={{'A','B','C','D','E'},{'F','G','H','I','J'},{'K','L','M','N','O'},{'P','Q','R','S','T'},{'U','V','W','X','Y'},{'Z','0','0','0','0'}};
		for(i=0;i<6;i++)
		{
			for(j=0;j<5;j++)
			{
				System.out.print(content[i][j]+" ");
			}
			System.out.println();
		}
		System.out.print("enter number of characters in your name:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int index[]=new int[n];
		int index1[]=new int[n];
		System.out.println("choose the row numbers corresponding letters of your name");
		for(i=0;i<n;i++)
		{
			index[i]=sc.nextInt();
		}
		char result[][]=new char[5][n];
		for(i=0;i<n;i++)
		{
			for(j=0;j<5;j++)
			{
				result[j][i]=content[index[i]-1][j];
			}
		}
		char resultf[][]=new char[n][n];
		for(i=0;i<5;i++)
		{
			for(j=0;j<n;j++)
			{
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("choose the row numbers corresponding letters of your name");
		for(i=0;i<n;i++)
		{
			index1[i]=sc.nextInt();
		}
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				resultf[j][i]=result[index1[i]-1][j];
			}
		}
		
		System.out.print("your name is:");
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(i==j)
				System.out.print(resultf[i][j]);
			}
		}
	}
}
