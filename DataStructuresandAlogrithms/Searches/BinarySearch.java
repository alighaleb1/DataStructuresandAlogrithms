package Sorts;

public class BinarySearch {

	public static void main(String[] args) 
	{
		//best case middle
		//o(n)=1000000
		//o(n)=lg N
		int[]	ar = {7,3,9,5,8,6,4,3,2,1,0};
		int key = 10;
		 int result = binarysearch(ar,key);
		 System.out.println(result);
	}

	private static int binarysearch(int[] ar, int key) 
	{
		int low=0;
		int mid=0;
		int high=ar.length-1;
		while(low<=high)
		{
			mid=(low+high)/2;
			if(ar[mid]==key) break;
			if(ar[mid]<key)
			{
				low=mid+1;
			}
			else
			{
				high=mid-1;
			}
		}
		return(ar[mid]);
	}
}
