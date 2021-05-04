package ElementarySorts;

public class InserationSort {

	public static void main(String[] args)
	{
		//inserts from bottom into sorted array
		//insert ar[1] into sorted ar[0.0] --> ar[0.1]
		////insert ar[2] into sorted ar[0.1] --> ar[0.2]
		//does same thing until end of array.
		//best case=ascending. 2*(n-1)
		//worst case=descending. 3+4+......+n+1.
		//3+4+......+n+1        (n+1)^2+n+2/2  - 3 
		int[] ar = {23,15,9,26,4,52,7};
		int j;
		int k;
		int temp;
		for(k=1;k<=ar.length-1;k++)
		{
			temp=ar[k];
			for(j = k-1; j>=0; j--)
			{
				if(ar[j]<temp) break;
					ar[j+1]=ar[j];
			}
				ar[j+1] = temp;
		}
		System.out.println(ar.length-1);
		
		//print sorted array.
		int b;
		for(b = 0 ;b< 5 ;b++)
		{
			System.out.println(ar[b]);
		}
	}

}
