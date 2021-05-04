package ElementarySorts;

public class SelectionSort {

	public static void main(String[] args) 
	{
		//Selection sort: find index 
		//of smallest elementar[0,5]
		//if smallestindex != 0
		//swap(ar[0], ar[smallest.index]) same goes for[j+1];
		int[] ar = {2,3,5,4,9,8,7,1};
		int k;
		int temp=0;
		for(k=0; k<ar.length-1; k++)
		{
			int smallest = findsmall(ar,k,ar.length-1);
			if(smallest != k)
				temp = ar[k];
				ar[k] = ar[smallest];
				ar[smallest] = temp;
		}
		
		for(int i=0; i<ar.length;i++)
			System.out.println(ar[i]);
	}

	private static int findsmall(int[] ar, int k, int i) 
	{
		int si = k;
		int j;
		for(j=k; j<=i; j++)
			if(ar[si] > ar[j])
				si = j;
		return (si);
	}
}
