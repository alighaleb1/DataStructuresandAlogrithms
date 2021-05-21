package DoublyDoubleEndedLinkedList;

//StudentRecord class for main DataBase array.
public class StudentRecord 
{
	
	//Student's information (first name, last name, and id number ).
	private String fname;
	private String lname;
	private String iD;
	
	//Constructor for students to be entered.
	public StudentRecord (String f, String l, String i)
	{
		fname = f;
		lname = l;
		iD = i;
	}
	
	//Getters for student's information.
	
	//Getter for first name.
	public String getFname() 
	{
		return fname;
	}

	//Getter for last name.
	public String getLname() 
	{
		return lname;
	}

	//Getter for Id number.
	public String getiD() 
	{
		return iD;
	}
	
	//Print student information in this order.
	public String toString()
	{
		return iD+" "+fname+" "+lname;
	}

}