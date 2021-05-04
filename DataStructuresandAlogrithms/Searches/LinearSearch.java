package Sorts;

public class LinearSearch {

	public static void main(String[] args)
	{
		//linear search best case it first element; O(c) = C or 1
		//worst cae n which is last element
		int ar[] = {2,4,5,9,3,5,4,2,};
		int t=3;
		int b= linearsearch(ar,3,0,ar.length);
		System.out.println(b);
	}

	private static int linearsearch(int[] ar, int i, int j, int length) {
		int b;
		for(b = j; b<length;b++)
			if(ar[b] == i) break;
		return b;
	}

}
