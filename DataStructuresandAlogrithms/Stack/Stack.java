package Stack;

public class Stack {
	
	int stackPtr;
	int data[];
	public Stack()
	
	{
		stackPtr=(0);
		data =new int[10];
		
	}
	
	public Stack(int sz)
	{
		stackPtr=0;
		data=new int [sz];
	}
	
	public void push (int val)
	{
		data[stackPtr++]=val;
	
	}
	
	public int pop()
	{
		int retVal = data [--stackPtr];
		return(retVal);
	}
	
	public boolean isEmpty()
	{
		return (stackPtr==0);
	}
	
	public boolean isFull()
	{
		return (stackPtr==data.length);
	
	}

}
