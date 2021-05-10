package BeginningJava;

import java.util.Scanner;

//How to get user input.
public class UserInput 
{

	public static void main(String[] args) 
	{
		//Import Scanner.
		Scanner input = new Scanner(System.in);

		//Get Integer value from user.
		System.out.print("Enter a Integer: ");
		int number = input.nextInt();
		
		//Get Double value from user.
		System.out.print("Enter a Double: ");
		double numberD = input.nextDouble();
		
		//Get a character from user.
		System.out.print("Enter a Letter: ");
		char letter = input.next().charAt(0);
		
		//skip the string issue
		input.nextLine();
		
		//Get a String from user.
		System.out.print("Enter a String: ");
		String sentence = input.nextLine();
		
		System.out.print("Enter a second String: ");
		String sentenceT = input.nextLine();
		
		System.out.println();
		
		//Print out user input.
		System.out.println("Integer: "+number+".\n"
				+"Double: "+numberD+" \n"
					+"Char: "+letter+".\n"
						+"String: "+sentence+".\n"
							+"String2: "+sentenceT+".\n");
	}

}

/*
	Enter a Integer: 99
	Enter a Double: 23.34
	Enter a Letter: G
	Enter a String: Programming is awesome!
	Enter a second String: Java is awesome!
	
	Integer: 99.
	Double: 23.34 
	Char: G.
	String: Programming is awesome!.
	String2: Java is awesome!.
*/