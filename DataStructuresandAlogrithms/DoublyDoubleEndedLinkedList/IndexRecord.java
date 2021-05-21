package DoublyDoubleEndedLinkedList;

//Doubly linked list.
public class IndexRecord 
{
	public IndexRecord prev, next; // Nodes
	public String key;// (id number, first name, or last name).
	public int where;//Position in main database.
	
	//Constructor for students info to be entered.
	public IndexRecord(String k, int w)
	{
		prev = null;
		next = null;
		this.key = k;
		this.where = w;
	}
	
	//Getters and Setters for DoublyLinked list.
	
	//Getter for previous .
	public IndexRecord getPrev() 
	{
		return prev;
	}
	
	//Setter for previous.
	public void setPrev(IndexRecord p) 
	{
		this.prev = p;
	}
	
	//Getter for next.
	public IndexRecord getNext() 
	{
		return next;
	}
	
	//Setter for next;
	public void setNext(IndexRecord next) 
	{
		this.next = next;
	}
	
	//Getter to get (first name,last name, and id number).
	public String getKey() 
	{
		return key;
	}
	
	//Getter to get position of a student in main database.
	public int getWhere() 
	{
		return where;
	}

	//Print id number or first name or last name with position in main database.
	public String toString()
	{
		return key+" "+where;
	}
	
	//Compareto method to enter in ascending order for the three strings(id number, first name, last name)
	public int compareTo(IndexRecord ir)
	{
		return key.compareTo(ir.key);
	}

	
}
