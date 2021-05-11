package BeginningJava;

public class IncrementOperators 
{

	public static void main(String[] args) 
	{
		int i=0;
		int b=0;
		int j,k;
		
		//Postfix
		//Increment
		j = i++;
		System.out.println(i);
		System.out.println("J is "+j);
		
		//Decrement
		j = i--;
		System.out.println(i);
		System.out.println("J is "+j);
		
		//Prefix
		k = ++b;
		System.out.println(b);
		System.out.println("K is "+j);
		
		
		k=--b;
		System.out.println(b);
		System.out.println("K is "+j);
	}

}
