package BeginningJava;

public class NumberGenerator 
{

	public static void main(String[] args) 
	{
		int num = (int) (Math.random() * 1000);
		System.out.println(num);
		
		double num2 = (double) (Math.random()*100.00);
		System.out.println(num2);
		
		short num3 = (short) (Math.random()*100);
		System.out.println(num3);
		
		long num4 = (long) (Math.random() * 1000000 );
		System.out.println(num4);
		
		float num5 = (float) (Math.random()* 300000.00);
	}

}
