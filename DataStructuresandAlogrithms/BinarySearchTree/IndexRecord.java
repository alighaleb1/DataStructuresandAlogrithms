package BinarySearchTree;

//Binary Search Tree.
public class IndexRecord 
{
	public IndexRecord left, right; // Nodes
	public String key;// (id number, first name, or last name).
	public int where;//Position in main database.
	
	//Constructor for students info to be entered.
	public IndexRecord(String k, int w)
	{
		left = null;
		right = null;
		this.key = k;
		this.where = w;
	}
	
	//Getter for left side .
	public IndexRecord getLeft() 
	{
		return left;
	}
	
	//Setter for left side
	public void setLeft(IndexRecord l) 
	{
		this.left= l;
	}
	
	//Getter for right side.
	public IndexRecord getRight() 
	{
		return right;
	}
	
	//Setter for right side;
	public void setRight(IndexRecord right) 
	{
		this.right = right;
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
