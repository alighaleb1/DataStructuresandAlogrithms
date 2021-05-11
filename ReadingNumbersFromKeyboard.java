package BeginningJava;

import java.util.Scanner;

// Reading numbers in with different variables.
public class ReadingNumbersFromKeyboard 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		//Byte 
		System.out.println("Enter a byte number: ");
		byte numB = input.nextByte();
		
		//Short
		System.out.println("Enter a short number: ");
		short numS = input.nextShort();
		
		//Integer
		System.out.println("Enter a int number: ");
		int numI = input.nextInt();
		
		//Long
		System.out.println("Enter a long number: ");
		long numL = input.nextLong();
		
		//Double
		System.out.println("Enter a double number: ");
		double numD = input.nextDouble();
		
		//Float
		System.out.println("Enter a float number: ");
		float numF = input.nextFloat();
	}

}
