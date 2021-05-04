package Cosc3144;
/*
Name : Ali Ghaleb
Date: 11/1/2020
Course: 314
Project #: 2
*/
//Import file reader and scanner.

import java.io.File;
import java.util.Scanner;
public class Project2
{
	public static void main(String[] args)  
	{
		boolean filefound = true;
		Scanner read = new Scanner(System.in);
		//File path.
		System.out.print("Please Enter File Name "
				+ "\nOr File Exact Location: ");
		String filename = read.nextLine();
		File file = new File(filename);
		//Matrix size row and column.
		int[][] matrix=new int[10][10];
		//Counter
		int i=0;
		//Reading matrix  into array
		String[][] input = new String[10][10];
		try 
		{
			int b = 0;
			String num = " ";
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				String[] split = line.split(" ");
				for( i=0; i<10; i++)
				{
					num = split[i];
					enterdata(input,matrix,num,i,b);
				}
				b++;
			}
		}
		catch(Exception ex)
		{
			filefound = false;
		}
		if(filefound != false)
		{
			//Check file for correct input(must be 0 or 1 only).
			boolean correctinput = BinaryInput(matrix,input);
			//Check  matrix array for following conditions : Reflexive? Symmetric? antiSymmetric? antiReflexive?
			if(correctinput == true)
			{
				//Methods to check if matrix if reflexive or anti reflexive.
				String reflexive = isReflexive0(matrix);
				String antireflexive = antiReflexive(matrix);
				//Methods to check if matrix if reflexive or anti reflexive.
				String symmetric = isSymmetric(matrix);
				String antisymmetric = isAntiSymmetric(matrix);
				if(symmetric == "Neither")
					symmetric = "No";
				if(antisymmetric == "Neither")
					antisymmetric = "No";
				//Output result for the matrix
				System.out.println("\nFile input : "+filename);
				System.out.println("Reflexive - "+reflexive);
				System.out.println("Anti-Reflexive - "+antireflexive);
				System.out.println("Symmetric -  "+symmetric);
				System.out.println("Antisymmetric - "+antisymmetric);
			}
			else
				//Incorrect output.
				System.out.println("File has incorrect input! "
				+ "\nPlease enter the correct file location "
				+ "\nand make sure the input is correct(Binary Matrix only!).");
		}
		else
			System.out.println("File Not Found!");
	}
	//Enter Binary Matrix into Dimensional Array
	private static void enterdata(String[][] input,int[][] matrix, String num, int i, int b)
	{
		input[b][i] = num;
		int index = Integer.parseInt(num);
		matrix[b][i] = index;
	}
	//Testing if the input is correct(Binary Matrix).
	private static boolean BinaryInput(int[][]matrix, String[][] input)
	{
		boolean correctinput = true;
		for(int b=0; b<10; b++)
		{
			for(int i=0; i<10; i++)
			{
				if(input[b][i].equals("0") || input[b][i].equals("1"))
					correctinput = true;
				else
					correctinput = false;

				if(correctinput == false)
					break;
			}
			if(correctinput == false)
				break;
		}
		return (correctinput);
	}
	//Check if Binary Matrix is Reflexive.
	private static String isReflexive0(int[][] matrix)
	{
		String reflexive = " ";
		if(matrix[0][0]  == 1 && matrix[1][1] == 1 && matrix[2][2]  == 1 && matrix[3][3] == 1 &&
				matrix[4][4]  == 1 && matrix[5][5] == 1 && matrix[6][6]  == 1 && matrix[7][7] == 1
				&& matrix[8][8]  == 1 && matrix[9][9] == 1 )
			reflexive = "Yes";
		else
			reflexive= "No";
		return (reflexive);
	}
	//Check if Binary Matrix is AntiReflexive.
	private static String antiReflexive(int[][] matrix)
	{
		String antireflexive = " ";
		if(matrix[0][0]  == 0 && matrix[1][1] == 0 && matrix[2][2]  == 0 && matrix[3][3] == 0 &&
				matrix[4][4]  == 0 && matrix[5][5] == 0 && matrix[6][6]  == 0 && matrix[7][7] == 0
				&& matrix[8][8]  == 0 && matrix[9][9] == 0 )
			antireflexive = "Yes";
		else
			antireflexive = "No";
		return(antireflexive);
	}
	//Check if Binary Matrix is  Symmetric.
	private static String isSymmetric(int[][] matrix)
	{
		String symmetric = "Neither";
		for(int i=0; i<10; i++)
		{
			for(int b=0 ; b<10; b++)
			{
				if(i != b && matrix[i][b] != 0)
					if(matrix[i][b] == matrix[b][i])
						symmetric = "Yes";
					else
						symmetric = "No";
				
					if(symmetric == "No")
						break;
			}
			if(symmetric == "No")
				break;
		}
		return (symmetric);
	}
	//Check if Binary Matrix is  AntiSymmetric.
	private static String isAntiSymmetric(int[][] matrix)
	{
		String antisymmetric = "Neither";
		for(int i=0; i<10; i++)
		{
			for(int b=0 ; b<10; b++)
			{
				if(i != b && matrix[i][b] != 0)
				{
					if(matrix[i][b] == 1 && matrix[b][i] == 0 )
						antisymmetric = "Yes";
					else
						antisymmetric = "No";
				}
				
				if(antisymmetric == "No")
					break;
			}
			
			if(antisymmetric == "No")
				break;
		}
		return(antisymmetric);
	}
}