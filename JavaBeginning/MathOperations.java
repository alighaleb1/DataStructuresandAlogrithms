package BeginningJava;

//Math operators.
public class MathOperations 
{

	public static void main(String[] args) 
	{
		int numberO = 90, numberT = 10;
		
		//Add,subtract,multiply,divide two integer values.
		int answerO = numberO + numberT;
		int answerT = numberO - numberT;
		int answertH = numberO * numberT;
		int answerF = numberO / numberT;
		int answerfI = numberO%numberT;
		
		
		//Print out answers
		System.out.println(numberO+" + "
		+numberT+" = "+answerO );
		
		System.out.println(numberO+" - "
				+numberT+" = "+answerT );
		
		System.out.println(numberO+" * "
				+numberT+" = "+answertH );
		
		System.out.println(numberO+" / "
				+numberT+" = "+answerF );
		
		System.out.println(numberO+" % "
				+numberT+" = "+answerfI );
	}

}

/*
	90 + 10 = 100
	90 - 10 = 80
	90 * 10 = 900
	90 / 10 = 9
	90 % 10 = 0
*/