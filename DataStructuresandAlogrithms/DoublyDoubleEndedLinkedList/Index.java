package DoublyDoubleEndedLinkedList;

//Index class to make a Doubly Double Ended Ordered LinkedList.
public class Index
{
	//Doubly Double Ended Ordered LinkedList with an iterator to print student's information.
	public IndexRecord front; 
	public IndexRecord back;
	public IndexRecord iterator; 

	//default constructor
	public Index()
	{
		front = null;
		back = null;
		iterator = null;
	}
	
	//Insert Id number, first name, last name(key) in ascending order 
	//with  position (where) in main database.
	public void insert(IndexRecord s) 
	{
		IndexRecord newNode = s;
		IndexRecord rover=front;
		
		if(front == null) 
		{	front = newNode;
			back = newNode;
		}
		else
		{
			while(rover.getNext()!=null && rover.compareTo(s)<0) { 
				rover = rover.getNext();
			}
		
			
			if(rover.compareTo(s)>0)
			{
				newNode.setNext(rover);
				newNode.setPrev(rover.getPrev());
				
				if(rover.getPrev() == null)
				{
					front = newNode;
				}
				else
				{
					rover.getPrev().setNext(newNode);
				}
				rover.setPrev(newNode);
				}
			else
			{
				newNode.setPrev(rover);
				newNode.setNext(rover.getNext());
				
				if(rover.getNext() == null)
				{
					back = newNode;
				}
				else
				{
					rover.getNext().setPrev(newNode);
				}
				rover.setNext(newNode);
			}
		}
			
	}
		
	//find a student through IndexRecord.
	public int find (String id)
	{
		IndexRecord rover = front;
		while(rover != null)
		{
			if(rover.getKey().compareTo(id) == 0) break;
			rover = rover.getNext();
		}
		return (rover != null? rover.getWhere() : -1);
	}
	
	//Delete a student from IndexRecord.
	public IndexRecord delete(String key) 
	{
		IndexRecord rover, prev;
		prev=front;
		rover=front;
		if(rover==null) 
		{
			rover = null;
		}
		else if(rover.getKey().compareTo(key) == 0)
		{
					front=rover.getNext();
		}
		else 
		{
			while(rover !=null)
			{
				if(rover.getKey().compareTo(key)==0) break;
					prev=rover;
					rover=rover.getNext();
			}
			if(rover == null)
				rover = null;
			else
				prev.setNext(rover.getNext());
		}
		return (rover);
	}
	
	//List student's id number or first name or last name.
	public void list()
	{
		IndexRecord rover = front;
		while(rover != null)
		{
			System.out.println(rover);
			rover = rover.getNext();
		}
	}
	
	//check if indexRecord is empty.
	public boolean isEmpty()
	{
		return (front == null );
	}

	//Return front to print first student.
	public int  getFront() 
	{
		return(front != null? front.getWhere(): -1);
	}
	
	//Return back to print to print last student.
	public int getBack() {
		return (back != null? back.getWhere():-1);
	}
	
	//Iterator to print students by id,first name, and last name.
	//Set Iterator to the start of IndexRecord(LinkedList) to print frontwards..
	public void start()
	{
		iterator = front;
	}
	
	//Check if IndexRecord has more Indexes so the Iterator continues at true and stops at false.
	public boolean hasNext()
	{
		if(iterator != null)
			iterator = iterator.getNext();
		
		return(iterator != null? true:false);
	}
	//Get positions of Indexes(positions of student in main database) from IndexRecord to print in ascending order.
	public int getNext()
	{
		int temp = iterator.where;
		
		return (temp != -1? temp:-1);
	}
	//Set iterator to end of IndexRecord to start printing backwards.
	public void end()
	{
		iterator = back;
	}
	//Check if IndexRecord has previous Indexes(positions of student in main database) through iterator..
	public boolean hasPrevious()
	{
		if(iterator != null)
			iterator =iterator.getPrev();
		
		return(iterator != null? true:false);
	}
	
	//Get previous Indexes(positions of student in main database) to print descending order from   IndexRecord(LinkedList).
	public int getPrevious()
	{
		int temp = iterator.getWhere();
		
		return (temp != -1? temp: -1); 
	}
}

