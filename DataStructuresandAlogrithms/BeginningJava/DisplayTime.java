package BeginningJava;

import java.util.Scanner;

//Display the time for the seconds entered by user.
public class DisplayTime 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the number of seconds: ");
		int seconds = input.nextInt();
		
		//Minutes
		int minutes = seconds / 60;
		
		//Seconds
		int remainingsecondS = seconds % 60;
		
		System.out.println(minutes+" Minutes and "+remainingsecondS
				+" Seconds.");
	}

}
/*
  Enter the number of seconds: 98765
  1646 Minutes and 5 Seconds.

*/