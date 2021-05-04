package ElementarySorts;

public class ExchangeSort {

	public static void main(String[] args) 
	{
		/* The exchange sort compares the first element with 
			each following element of the array, making any necessary swaps.*/
		 
		int[] ar = {88,5,6,59,100};
		int j;
		int k;
		int temp;
		for(j=1; j<ar.length;j++)
		{
			for(k=4;k>=j;k--)
			{
				temp = ar[k];
				ar[k]=ar[k-1];
				ar[k-1]= temp;
			}
		}

	}

}
