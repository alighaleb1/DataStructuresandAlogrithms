package GenericorderedArray;

public class OrderedArray 
{
	private int nElems;
	private int maxSize;
	private Student[] data;
	
	public OrderedArray()
	{
		maxSize=10;
		nElems=0;
		data=new Student[maxSize];
	}
	
	public OrderedArray(int sz)
	{
		maxSize=sz;
		nElems=0;
		data=new Student[maxSize];
	}
	
	public void insert(Student newNum)
	{
		int j;
		for(j=nElems-1;j>=0; j--)
		{
			if(data[j].compareTo(newNum) < 0) break;
			data[j+1] = data[j];
		}
		data[j+1] = newNum;
		nElems++;
	}
	
	public int search( String newNum)
	{
		int low=0;
		int high=nElems-1;
		int mid=0;
		while(low<=high)
		{
			mid=(low+high)/2;
			
			if(data[mid].getFname().compareTo(newNum) == 0)break;
			
			if(data[mid].getFname().compareTo(newNum)< 0)
			{
				low = mid+1;
			}
			else
			{
				high = mid-1;
			}
		}
		
		return(data[mid].getFname() == newNum? mid:-1);
	}
	
	public int delete(String newNum)
	{
		int where;
		int k;
		where = search(newNum);
		if(where != -1)
		{
			for(k=where+1; k<nElems ; k++)
			{
				data[k-1] = data[k];
			}
			nElems--;
		}
		return (where==-1?-1:1);
	}
	
	public void list()
	{
		for(int i=0; i<data.length;i++)
			System.out.println(data[i]);
	}
	
	public boolean isEmpty()
	{
		return (nElems == 0);
	}
	
	public boolean isFull()
	{
		return (nElems == maxSize);
	}
}
