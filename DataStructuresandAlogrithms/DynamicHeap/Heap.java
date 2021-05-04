package DynamicHeap;

public class Heap 
{
	private StudentAge[] heap;
	private int maxSize;
	private int currentSize;
	
	public Heap(int max)
	{
		maxSize = max;
		currentSize = 0;
		heap = new StudentAge[max];
	}
	
	
	
	public void push(int key)
	{
		StudentAge student = new StudentAge(key);
		heap[currentSize] = student;
		trickleup(currentSize++);
	}
	
	
	
	public void trickleup(int index)
	{
		int parent = (index-1)/2;
		StudentAge bottom = heap[index];
		while(index>0 && heap[parent].getAge() < bottom.getAge())
		{
			heap[index] = heap[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		heap[index] = bottom;
	}
	
	public StudentAge pop()
	{
		StudentAge root = heap[0];
		heap[0] = heap[currentSize-1];
		trickledown(0);
		currentSize--;
		return root;
	}
	
	public void trickledown(int index)
	{
		int largerchild;
		StudentAge top = heap[index];
		while(index<currentSize/2)
		{
			int leftchild = 2*index+1;
			int rightchild = leftchild+1;
			
			if(rightchild<currentSize && heap[leftchild].getAge()
					<heap[rightchild].getAge())
			{
				largerchild = rightchild;
			}
			else
			{
				largerchild = leftchild;
			}
				
			if(top.getAge() == heap[largerchild].getAge())
			{
				break;
			}
			
			heap[index] = heap[largerchild];
			index = largerchild;
		}
		heap[index] = top;
	}
	
	public boolean change(int index, int newvalue)
	{
		if(index<0 || index>=currentSize)
			return false;
		
		int oldvalue = heap[index].getAge();
		heap[index].setAge(newvalue);
		
		if(oldvalue < newvalue)
			trickleup(index);
		else
			trickledown(index);
		return true;
	}
	
	public void displayHeap()
	{
		System.out.print("heapArray:   ");
		for(int m =0; m<currentSize; m++)
			if(heap[m] != null)
				
				System.out.println(heap[m].getAge()+" ");
			else
				System.out.println("-- ");
		System.out.println();
		
	} // end class Heap
}