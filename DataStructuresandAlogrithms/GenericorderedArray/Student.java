package GenericorderedArray;

public class Student 
{
	private String fname;
	private String lname;
	private int id;
	private char gender;
	
	public Student(String f, String l, int a, char g)
	{
		fname = f;
		lname = l;
		id = a;
		gender = g;
	}
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String toString() 
	{
		return fname+" "+lname+" "+id+" "+gender; 
	}
	
	public int compareTo(Student newStudent)
	{
		return fname.compareTo(newStudent.fname);
	}
}
