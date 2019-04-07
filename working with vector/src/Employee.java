import java.io.Serializable;


public class Employee implements Serializable {
	String name,sal;
	Employee(String name,String sal){
		this.name=name;
		this.sal=sal;
	}
	void read(){
		System.out.println("Name = "+name+"Sal = "+sal);
	}
}
