package COSC314;

public class LinkedList 
{
	private Node front;
	private Node back;
	
	public LinkedList()
	{
		front = null;
		back = null;
	}
	
	public void insertPath(Node newPath)
	{
		if(front == null)
		{
			front = newPath;
		}
		else
		{
			back.setNext(newPath);
		}
		back = newPath;
	}
	
	public void print()
	{
		Node rover  = front;
		while(rover != null)
		{
			System.out.println(rover);
			rover = rover.getNext();
		}
	}
}
