package BeginningJava;

import java.util.Scanner;

//Quiz for addition for a user.
public class SumofTwogeneratedNumbers 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int i=0;
		
		do 
		{
			//Generate two numbers.
			int num1 = (int) (Math.random()*1000);
			int num2 = (int) (Math.random()*1000);
			int correctansweR = num1 + num2;
			
			//Display question
			System.out.print(num1+" + "+num2+" = ");
			int useransweR = (int) input.nextInt();
			
			//Check answer
			if(useransweR == correctansweR)
			{
				System.out.println("You are correct!");
			}
			else
				System.out.println("Wrong answer!");
			
			System.out.println();
			
			//Ask user if he wants to try again.
			System.out.println("Enter 0 to get a new Question. \n"
					+ "Enter 1 to Exit.");
			System.out.println();
			System.out.print("Your Choice: ");
			i = input.nextInt();
			
		} while(i != 0);

	}

}
