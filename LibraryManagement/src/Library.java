import java.util.*;
import java.io.*;
class Date1 implements Serializable
{
	public int d;
	public int m;
	public int y;
}
class Book implements Serializable
{
	public int bookId;
	public String author;
	public String name;
	public float price;
	public int rackNo;
	public String status;
	public String edition;
	public Date1 dateOfPurchase=new Date1();
	public void getDetail(int bid)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(System.out);
		bookId=bid;
		ps.println("book id:"+bid);
		ps.print("enter author name:");
		author=br.readLine();
		ps.print("enter name of the book:");
		name=br.readLine();
		ps.print("enter price of the book:");
		price=Float.parseFloat(br.readLine());
		ps.print("enter rack number for book:");
		rackNo=Integer.parseInt(br.readLine());
		ps.print("enter status of the book:");
		status=br.readLine();
		ps.append("enter edition:");
		edition=br.readLine();
		ps.print("enter date of purchase (dd mm yyyy):");
		dateOfPurchase.d=sc.nextInt();
		dateOfPurchase.m=sc.nextInt();
		dateOfPurchase.y=sc.nextInt();
	}
	public void displayBookDetails()throws IOException
	{
		PrintStream ps = new PrintStream(System.out);
		ps.println("	bookId:"+bookId);
		ps.println("	author name:"+author);
		ps.println("	name of book:"+name);
		ps.println("	price for book:"+price);
		ps.println("	rackNo for the book:"+rackNo);
		ps.println("	status of the book:"+status);
		ps.println("	edition:"+edition);
		ps.println("	date of purchase :"+dateOfPurchase.d+" "+dateOfPurchase.m+" "+dateOfPurchase.y);
	}
	public void updateStatus(int bid,ArrayList<Book> b,String str)throws IOException
	{
		int i;
		for(i=0;i<b.size();i++)
		{
			if(b.get(i).bookId==bid)
			{
				b.get(i).status=str;
			}
		}
	}
	public void showBill(int mid, int billno, ArrayList<Bill> bill) 
	{
		PrintStream ps = new PrintStream(System.out);
		ps.print("");
	}
}
class Librarian implements Serializable
{
	String name;
	String password;
	public void getAthourity() throws IOException
	{
		PrintStream ps=new PrintStream(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ps.print("enter your username:");
		name=br.readLine();
		ps.print("enter your password:");
		password=br.readLine();
	}
	public int searchBook(String temp_name,ArrayList<Book> b) throws ArrayIndexOutOfBoundsException
	{
		int i;
		for(i=0;i<b.size();i++)
		{
			if(temp_name.toLowerCase().equals(b.get(i).name.toLowerCase()) && b.get(i).status.toLowerCase().equals("available"))
			{
				return b.get(i).bookId;
			}
		}
		return -1;
	}
	public String verifyMember(int mid,ArrayList<MemberRecord> mr)
	{
		int i=-1;
		if(mr.size()!=0)
		for(i=0;i<mr.size();i++)
		{
			if(mid==mr.get(i).memberId)
			{
				break;
			}
		}
		if(i==mr.size())
			return "x";
		else
			return mr.get(i).type;
	}
	void issueBook(int bid,ArrayList<Book> b,int tid,int mid , ArrayList<Transaction> t2)throws IOException,ArrayIndexOutOfBoundsException,NullPointerException
	{
		PrintStream ps=new PrintStream(System.out);
		Book b1=new Book();
		Transaction t=new Transaction();
		int i=-1,p=-1;
		String str=new String("not available");
		for(i=0;i<b.size();i++)
		{
			if(bid==b.get(i).bookId)
			{
				b1.updateStatus(bid,b,str);
				t.createTransaction(tid,mid,bid,t2);
				break;
			}
		}
	}
	long calculateFine(int mid,int tid,Transaction tr) throws NumberFormatException
	{
		PrintStream ps=new PrintStream(System.out);
		Scanner sc=new Scanner(System.in);
		Date1 dd=new Date1();
		Date1 cd=new Date1();
		long z=0;
		dd.d=tr.dueDate.d;
		dd.m=tr.dueDate.m;
		dd.y=tr.dueDate.y;
		ps.println("	due date is:"+dd.d+" "+dd.m+" "+dd.y);
		ps.println("	enter current date(dd mm yyyy):");
		cd.d=sc.nextInt();
		cd.m=sc.nextInt();
		cd.y=sc.nextInt();
		long u=(dd.d)+(dd.m)*30+(dd.y)*365;
		long v=(cd.d)+(cd.m)*30+(cd.y)*365;
		z=v-u;
		if(z>0)
		{
			ps.println("	you have to pay "+z+" rupees fine for the late submission.");
		}
		return z;
	}
	void createBill(int mid,int billno,int amou,ArrayList<Bill> bill)
	{
		Bill bi=new Bill();
		bi.billCreate(mid,billno,amou,bill);
	}
	void returnBook(int bid,ArrayList<Book> b,int transid,int mid,ArrayList<Transaction> t2)throws IOException,ArrayIndexOutOfBoundsException,NullPointerException
	{
		PrintStream ps=new PrintStream(System.out);
		int i;
		Book b1=new Book();
		Transaction t=new Transaction();
		String str=new String("available");
	    for(i=0;i<t2.size();i++)
	    {
	    	if(b.get(i).bookId==bid)
	    	{
				b.get(i).status="available";
				b1.updateStatus(bid,b,str);
		        t.deleteTransaction(transid,mid,bid,t2);
	    	}
	    }
	}
}
class Library
{
	public static void main(String args[])throws IOException,ClassNotFoundException,EOFException,NullPointerException,ArrayIndexOutOfBoundsException
	{
		int transid;
		int bid;
		int billno;
		int mid;
		
		PrintStream ps=new PrintStream(System.out);
		Scanner sc=new Scanner(System.in);
				
		FileInputStream fis=null;
		ObjectInputStream ois = null;
		
		//reading Librarian file
		ArrayList<Librarian> lib=new ArrayList<Librarian>();
		try
		{
			fis=new FileInputStream("Librarian.txt");
		}
		catch(NullPointerException e)
		{
			ps.print("");
		}
		try
		{
			ois=new ObjectInputStream(fis);
		}
		catch(EOFException e)
		{
			ps.print("");
		}
		try
		{
			Librarian lll=new Librarian();
			while((lll=(Librarian)ois.readObject())!=null)
			{
				lib.add(lll);
			}
		}
		catch(Exception e)
		{
			ps.print("");
		}
		finally
		{
			try
			{
				ois.close();
			}
			catch(NullPointerException e)
			{
				ps.print("");
			}
		}	
		//reading book file
		ArrayList<Book> b = new ArrayList<Book>();
		try
		{
			fis=new FileInputStream("Book.txt");
		}
		catch(NullPointerException e)
		{
			ps.print("");
		}
		try
		{
			ois=new ObjectInputStream(fis);
		}
		catch(EOFException e)
		{
			ps.print("");
		}
		try
		{
			Book bk=new Book();
			while((bk=(Book)ois.readObject())!=null)
			{
				b.add(bk);
			}
		}
		catch(Exception e)
		{
			ps.print("");
		}
		finally
		{
			try
			{
				ois.close();
			}
			catch(NullPointerException e)
			{
				ps.print("");
			}
		}	
		
		//reading member record file
		ArrayList<MemberRecord> mr=new ArrayList<MemberRecord>();
		try
		{
			fis=new FileInputStream("MemberRecord.txt");
		}
		catch(NullPointerException e)
		{
			ps.print("");
		}
		try
		{
			ois=new ObjectInputStream(fis);
		}
		catch(EOFException e)
		{
			ps.print("");
		}
		try
		{
			MemberRecord mrrd=new MemberRecord();
			while((mrrd=(MemberRecord)ois.readObject())!=null)
			{
				mr.add(mrrd);
			}
		}
		catch(Exception e)
		{
			ps.print("");
		}
		finally
		{
			try
			{
				ois.close();
			}
			catch(NullPointerException e)
			{
				ps.print("");
			}
		}	
		
		//reading all transaction
		ArrayList<Transaction> t = new ArrayList<Transaction>();
		try
		{
			fis=new FileInputStream("Transaction.txt");
		}
		catch(NullPointerException e)
		{
			ps.print("");
		}
		try
		{
			ois=new ObjectInputStream(fis);
		}
		catch(EOFException e)
		{
			ps.print("");
		}
		try
		{
			Transaction trsn=new Transaction();
			while((trsn=(Transaction)ois.readObject())!=null)
			{
				t.add(trsn);
			}
		}
		catch(Exception e)
		{
			ps.print("");
		}
		finally
		{
			try
			{
				ois.close();
			}
			catch(NullPointerException e)
			{
				ps.print("");
			}
		}	
		
		//reading all bills from file
		ArrayList<Bill> bill = new ArrayList<Bill>();
		try
		{
			fis=new FileInputStream("Bill.txt");
		}
		catch(NullPointerException e)
		{
			ps.print("");
		}
		try
		{
			ois=new ObjectInputStream(fis);
		}
		catch(EOFException e)
		{
			ps.print("");
		}
		try
		{
			Bill bi=new Bill();
			while((bi=(Bill)ois.readObject())!=null)
			{
				bill.add(bi);
			}
		}
		catch(Exception e)
		{
			ps.print("");
		}
		finally
		{
			try
			{
				ois.close();
			}
			catch(NullPointerException e)
			{
				ps.print("");
			}
		}
		ps.println("books:"+b.size()+"  memberrecords:"+mr.size()+" transactions:"+t.size()+" bills:"+bill.size());
		ps.println();
		Librarian l = new Librarian();
		MemberRecord m=new MemberRecord();
		Transaction tr = new Transaction();
		Book b1=new Book();
		Bill bi=new Bill();
		
		if(b.size()==0)
			bid=0;
		else
			bid=b.get(b.size()-1).bookId;
		
		if(mr.size()==0)
			mid=0;
		else
			mid=mr.get(mr.size()-1).memberId;
		
		if(t.size()==0)
			transid=0;
		else
			transid=t.get(t.size()-1).transId;
		
		if(bill.size()==0)
			billno=0;
		else
			billno=bill.get(bill.size()-1).billNo;
		
		BufferedReader brr=new BufferedReader(new InputStreamReader(System.in));
		ps.print("enter username:");
			String usn=brr.readLine();
		ps.print("enter password:");
			String pass=brr.readLine();
		if(pass.equals(lib.get(0).password)&& usn.equals(lib.get(0).name))
		{
			while(true)
			{
				int choice;
				ps.println("	1.Student");
				ps.println("	2.Faculty");
				ps.print("enter your choice:");
				choice=sc.nextInt();
				switch(choice)
				{
					case 1:
						int stc;
						while(true)
						{
							ps.print("enter your memberId:");
							int temp_mid=sc.nextInt();
							String type=l.verifyMember(temp_mid, mr);
							if(type.toLowerCase().equals("student"))
							{
								ps.println("	you are member...you proceed!.");
							}
							else
							{
								ps.println("sorry... you are not member of this..");
								break;
							}
							ps.println("	1.Issue a book");
							ps.println("	2.Return a book");
							ps.print("enter your choice(Student):");
							stc=sc.nextInt();
							switch(stc)
							{
								case 1:
									ps.print("enter name of the book:");
									String bname=sc.next();
									int temp_bid=l.searchBook(bname,b);
									if(temp_bid!=-1)
									{
										ps.println("details of student is..");
										m=m.retriveMember(temp_mid,mr);
										if(m.noBookIssued>=m.maxBookLimit)
										{
											ps.println("	sorry..you can't take book now..crossing limit.");
										}
										else
										{
											transid+=1;
											l.issueBook(temp_bid,b,transid,temp_mid,t);
											m.increaseBookIssued(temp_mid,mr);
											tr.retrieveTransation(temp_bid,temp_mid,t);
											ps.println("	your book is issued");
										}
									}
									else
									{
										ps.println("	book is not available");
									}
									break;
								case 2:
									for(int a=0;a<t.size();a++)
									{
										if(t.get(a).memberId==temp_mid)
											ps.println("bid:"+t.get(a).bookId+" due date:"+t.get(a).dueDate.d+" "+t.get(a).dueDate.m+" "+t.get(a).dueDate.y);
									}
									ps.print("	enter book Id of the book you want to submit:");
									temp_bid=sc.nextInt();
									try
									{
										tr=tr.retrieveTransation(temp_bid,temp_mid,t);
									}
									catch(NullPointerException e)
									{
										ps.print("");
									}
									if(tr!=null)
									{
										if(tr.memberId==temp_mid && tr.bookId==temp_bid)
										{
											l.returnBook(temp_bid,b,tr.transId,temp_mid,t);
											m.decreaseBookIssued(temp_mid,mr);
											int fine=(int)l.calculateFine(temp_mid,transid,tr);
							                if(fine>0)
							                {
												billno+=1;
							                  	l.createBill(temp_mid,billno,fine,bill);
												ps.println("	your bill is:");
												bi.showBill(temp_mid,billno,bill);
											}
										}
									}
									
									else
									{
										ps.println("	you can't return..this book was not issued by you.");
									}
									break;
								default:
									stc=3;
									break;
							}
							if(stc==3)
							{
								break;
							}
						}
						break;
						//faculty  here
					case 2:
						int tec;
						while(true)
						{
							ps.println("	enter your memberId:");
							int temp_mid=sc.nextInt();
							String type=l.verifyMember(temp_mid,mr);
							if(type.toLowerCase().equals("faculty"))
							{
								ps.println("	you are member...you proceed!.");
							}
							else
							{
								ps.println("	sorry... you are not member of this..");
								break;
							}
							ps.println("	1.Issue a book");
							ps.println("	2.Return a book");
							ps.print("enter your choice(Faculty):");
							tec=sc.nextInt();
							switch(tec)
							{
								case 1:
									ps.print("enter name of the book:");
									String bname=sc.next();
									int temp_bid=l.searchBook(bname,b);
									if(temp_bid!=-1)
									{
										ps.println("details of faculty is..");
										m=m.retriveMember(temp_mid,mr);
										if(m.noBookIssued>=m.maxBookLimit)
										{
											ps.println("	sorry..you can't take book now..crossing limit.");
										}
										else
										{
											transid+=1;
											l.issueBook(temp_bid,b,transid,temp_mid,t);
											m.increaseBookIssued(temp_mid,mr);
											tr.retrieveTransation(temp_bid,temp_mid,t);
											ps.println("	your book is issued");
										}
									}
									else
									{
										ps.println("	book is not available");
									}
									break;
								case 2:
									for(int a=0;a<t.size();a++)
									{
										if(t.get(a).memberId==temp_mid)
											ps.println("bid:"+t.get(a).bookId+" due date:"+t.get(a).dueDate.d+" "+t.get(a).dueDate.m+" "+t.get(a).dueDate.y);
									}
									ps.print("	enter book Id of the book you want to submit:");
									temp_bid=sc.nextInt();
									try
									{
										tr=tr.retrieveTransation(temp_bid,temp_mid,t);
									}
									catch(NullPointerException e)
									{
										ps.print("");
									}
									if(tr!=null)
									{
										if(tr.memberId==temp_mid && tr.bookId==temp_bid)
										{
											l.returnBook(temp_bid,b,tr.transId,temp_mid,t);
											m.decreaseBookIssued(temp_mid,mr);
											int fine=(int)l.calculateFine(temp_mid,transid,tr);
							                if(fine>0)
							                {
												billno+=1;
							                  	l.createBill(temp_mid,billno,fine,bill);
												ps.println("	your bill is:");
												bi.showBill(temp_mid,billno,bill);
											}
										}
									}
									else
									{
										ps.println("	you can't return..this book was not issued by you.");
									}
									break;
								default:
									tec=3;
									break;
							}
							if(tec==3)
							{
								break;
							}
						}
						break;
					default:
						choice=3;
						break;
				}
				if(choice==3)
				{
					break;
				}
			}
			while(true)
			{
				ps.println("1. add book");
				ps.println("2. add member");
				ps.print("enter your choice:");
				int choice=sc.nextInt();
				switch(choice)
				{
					case 1:
						Book badd=new Book();
						bid+=1;
						badd.getDetail(bid);
						b.add(badd);
						break;
					case 2:
						MemberRecord madd=new MemberRecord();
						mid++;
						madd.getDetail(mid);
						mr.add(madd);
						break;
					default:
						choice=3;
						break;					
				}
				if(choice==3)
				{
					ps.println("exiting...");
					break;
				}
			}
			
			ps.println("		you are done!");
			ps.println("	THANK YOU!!!");

			FileOutputStream fos;
			ObjectOutputStream oos;

			fos=new FileOutputStream("Book.txt");
			oos=new ObjectOutputStream(fos);
			for(Book s:b)
			{
				oos.writeObject(s);
			}
			oos.close();
			
			fos=new FileOutputStream("MemberRecord.txt");
			oos=new ObjectOutputStream(fos);
			for(MemberRecord a:mr)
			{
				oos.writeObject(a);
			}
			oos.close();
			
			fos=new FileOutputStream("Transaction.txt");
			oos=new ObjectOutputStream(fos);
			for(Transaction z:t)
			{
				oos.writeObject(z);
			}
			oos.close();
			
			fos=new FileOutputStream("Bill.txt");
			oos=new ObjectOutputStream(fos);
			for(Bill d:bill)
			{
				oos.writeObject(d);
			}
			oos.close();
		}
		else
			ps.print("sorry... you are not librarian");
	}	
}
class Transaction implements Serializable
{
	public int transId;
	public int memberId;
	public int bookId;
	public Date1 dateOfIssue=new Date1();
	public Date1 dueDate=new Date1();
	public void createTransaction(int tid,int mid,int bid,ArrayList<Transaction> t2)
	{
		PrintStream ps=new PrintStream(System.out);
		Transaction t=new Transaction();
		t.transId=tid;
		t.bookId=bid;
		t.memberId=mid;
		t.bookId=bid;
		ps.print("	enter issue date(dd mm yyyy):");
		Scanner sc=new Scanner(System.in);
	    t.dateOfIssue.d=sc.nextInt();
	    t.dateOfIssue.m=sc.nextInt();
	    t.dateOfIssue.y=sc.nextInt();
		t.dueDate.d=(t.dateOfIssue.d+15)%30;
		t.dueDate.m=(t.dateOfIssue.m+(t.dateOfIssue.d+15)/30)%12;
		t.dueDate.y=t.dateOfIssue.y+((t.dateOfIssue.m+(t.dateOfIssue.d+15)/30)/12);
		t2.add(t);
	}
	public void deleteTransaction(int tid,int mid,int bid,ArrayList<Transaction> t)throws NullPointerException
	{
		PrintStream ps=new PrintStream(System.out);
		int i;
		for(i=0;i<t.size();i++)
		{
			if(bid==t.get(i).bookId)
				t.get(i).bookId=0;
		}
	}
	public Transaction retrieveTransation(int bid,int mid,ArrayList<Transaction> t)
	{
		PrintStream ps=new PrintStream(System.out);
		int i;
		for(i=0;i<t.size();i++)
		{
			if(bid==t.get(i).bookId && mid==t.get(i).memberId)
			{
				ps.println("	transId:"+t.get(i).transId);
				ps.println("	memberId:"+t.get(i).memberId);
				ps.println("	bookId:"+t.get(i).bookId);
				ps.println("	date of issue:"+t.get(i).dateOfIssue.d+"-"+t.get(i).dateOfIssue.m+"-"+t.get(i).dateOfIssue.y);
				ps.println("	due date:"+t.get(i).dueDate.d+"-"+t.get(i).dueDate.m+"-"+t.get(i).dueDate.y);
				break;
			}
		}
		if(i==t.size()||i==-1)
			return null;
		else
			return t.get(i);
	}
}
class MemberRecord implements Serializable
{
	public int memberId;
	public String type;
	public Date1 dateOfMembership=new Date1();
	public int noBookIssued;
	public int maxBookLimit;
	public String name;
	public String address;
	public String phoneNo;
	public void getDetail(int mid)throws IOException
	{
		PrintStream ps = new PrintStream(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		memberId=mid;
		ps.println("member id:"+memberId);
		ps.print("enter type of member:");
		type=br.readLine();
		ps.print("enter date of membership (dd mm yyyy):");
		dateOfMembership.d=sc.nextInt();
		dateOfMembership.m=sc.nextInt();
		dateOfMembership.y=sc.nextInt();
		ps.print("enter number of books issued:");
		noBookIssued=Integer.parseInt(br.readLine());
		ps.print("enter maximum number of books can be issued:");
		maxBookLimit=Integer.parseInt(br.readLine());
		ps.print("enter address");
		address=br.readLine();
		ps.print("enter name of the member:");
		name=br.readLine();
		ps.print("enter mobile number:");
		phoneNo=br.readLine();
	}
	public MemberRecord retriveMember(int mid,ArrayList<MemberRecord> mr)
	{
		PrintStream ps=new PrintStream(System.out);
		int i;
		for(i=0;i<mr.size();i++)
		{
			if(mid==mr.get(i).memberId)
			{
				ps.println("	memberId:"+mr.get(i).memberId);
				ps.println("	type:"+mr.get(i).type);
				ps.println("	Date of membership:"+mr.get(i).dateOfMembership.d+" "+mr.get(i).dateOfMembership.m+" "+mr.get(i).dateOfMembership.y);
				ps.println("	no. of book issued:"+mr.get(i).noBookIssued);
				ps.println("	max. book limit:"+mr.get(i).maxBookLimit);
				ps.println("	name:"+mr.get(i).name);
				ps.println("	address:"+mr.get(i).address);
				ps.println("	phone number:"+mr.get(i).phoneNo);
				break;
			}
		}
		if(i==mr.size())
		{
			ps.println("	member is not there in list");
			return null;
		}
		else
			return mr.get(i);
	}
	public void increaseBookIssued(int mid,ArrayList<MemberRecord> mr)
	{
		PrintStream ps=new PrintStream(System.out);
		int i;
		for(i=0;i< mr.size();i++)
		{
			if(mid==mr.get(i).memberId)
			{
				mr.get(i).noBookIssued+=1;
				ps.println("	no. of book issued for you:"+mr.get(i).noBookIssued);
			}
		}
	}
	public void decreaseBookIssued(int mid,ArrayList<MemberRecord> mr)
	{
		PrintWriter pw=new PrintWriter(System.out);
		int i;
		for(i=0;i<mr.size();i++)
		{
			if(mid==mr.get(i).memberId)
			{
				mr.get(i).noBookIssued-=1;
				pw.println("	no. of book issued for you:"+mr.get(i).noBookIssued);
			}
		}
	}
	public void payBill()
	{
		PrintWriter pw=new PrintWriter(System.out);
		pw.println("payBill");
	}
}
class Bill implements Serializable
{
	public int billNo;
	public Date1 date=new Date1();
	public int memberId;
	public int amount;
	public void showBill(int mid,int bn,ArrayList<Bill> bill )
	{
		PrintStream ps=new PrintStream(System.out);
		int i;
		for(i=0;i<bill.size();i++)
		{
			if(mid==bill.get(i).memberId)
			{
				ps.println("	bill no.:"+bill.get(i).billNo);
				ps.println("	date:"+bill.get(i).date.d+"-"+bill.get(i).date.m+"-"+bill.get(i).date.y);
				ps.println("	memberId:"+bill.get(i).memberId);
				ps.println("	amount:"+bill.get(i).amount);
				break;
			}
		}
	}
	public void billCreate(int mid,int bn,int fine,ArrayList<Bill> bill)
	{
		PrintStream ps=new PrintStream(System.out);
		Bill bi=new Bill();
		bi.billNo=bn;
		ps.println("	enter current date(dd mm yyyy):");
	    Scanner sc=new Scanner(System.in);
	    bi.date.d=sc.nextInt();
	    bi.date.m=sc.nextInt();
	    bi.date.y=sc.nextInt();
		bi.memberId=mid;
		bi.amount=fine;
		bill.add(bi);
	}
	public void billUpdate()
	{
		PrintStream ps=new PrintStream(System.out);
		ps.println("billUpdate");
	}
}
