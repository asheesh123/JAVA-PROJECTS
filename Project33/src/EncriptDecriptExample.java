import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class EncriptDecriptExample {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println("1.Encript your file with a given key.");
			System.out.println("2.Decript your file with a given key.");
			System.out.print("Enter your choice:");
			int choice=Integer.parseInt(br.readLine());
			switch(choice)
			{
				case 1:
					System.out.print("Enter file name to be encripted:");
					String rfname=br.readLine();
					System.out.print("Enter key value:");
					int key=Integer.parseInt(br.readLine());
					System.out.print("Enter in which file you want to encript:");
					String wfname=br.readLine();
					FileInputStream fis=new FileInputStream(rfname);
					FileOutputStream fos=new FileOutputStream(wfname);
					int ch;
					while((ch=fis.read())!=-1)
					{
						fos.write((char)(ch+key));
						//System.out.println((char)(ch+key));
					}
					fis.close();
					fos.close();
					break;
				case 2:
					System.out.print("Enter file name to be decripted:");
					rfname=br.readLine();
					System.out.print("Enter key value:");
					key=Integer.parseInt(br.readLine());
					System.out.print("Enter in which file you want to decript:");
					wfname=br.readLine();
					fis=new FileInputStream(rfname);
					fos=new FileOutputStream(wfname);
					while((ch=fis.read())!=-1)
					{
						fos.write((char)(ch-key));
						System.out.print((char)(ch-key));
					}
					fis.close();
					fos.close();
					break;
				default:
					choice=3;
					break;
			}
			if(choice==3)
			{
				System.out.println("exiting.....");
				break;
			}
		}
	}
}
