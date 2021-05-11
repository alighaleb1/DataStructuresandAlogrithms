package BeginningJava;

//find error in assignment expression.
public class IdentifyError 
{

	public static void main(String[] args) 
	{
		//Answer
		int j=0, k=0;
		
		//Answer j and k must be declared first.
		int i = j = k = 2;
		
		System.out.println(i + " " + j + " " + k);
	}

}
