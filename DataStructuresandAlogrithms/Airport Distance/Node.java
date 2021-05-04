package COSC314;

public class Node 
{
	public Node next;
	private String path;
	
	public Node(String p)
	{
		this.path = p;
		next = null;
	}

	public String toString()
	{
		return path+" ";
	}
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
