package AdvancedSorts;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AdvancedSortsProject
{
	public static void main(String[] args)
	{
		Scanner  input=new Scanner(System.in);
		int i=0;
		//Nine arrays to test nine cases sorting(Advanced sorts)
		int[] ascendingQ = new int[10000];
		int[] descendingQ = new int[10000];
		int[] randomQ = new int[10000];
		int[] ascendingH = new int[10000];
		int[] descendingH = new int[10000];
		int[] randomH = new int[10000];
		int[] ascendingM = new int[10000];
		int[] descendingM = new int[10000];
		int[] randomM = new int[10000];
		
		//Get three file names
		System.out.println("Enter the name of the three input files!");
		System.out.print("-----------------------------------------------------------------------------------------");
		System.out.print("\nFile One: ");
		String file1 = input.next();
		System.out.print("File Two: ");
		String file2 = input.next();
		System.out.print("File Three: ");
		String file3 = input.next();
		System.out.print("-----------------------------------------------------------------------------------------");
		
		//Get output file name.
		System.out.print("\nOutput File Name: ");
		String outputfilename = input.next();
		System.out.print("-----------------------------------------------------------------------------------------");
		System.out.println();
		
		File fileA = new File(file1);
		File fileD = new File(file2);
		File fildR = new File(file3);
		
		try 
		{
			Scanner scanA = new Scanner(fileA);
			Scanner scanD = new Scanner(fileD);
			Scanner scanR = new Scanner(fildR);
			while(scanA.hasNextLine())
			{
				String numberA = scanA.nextLine();
				String numberD = scanD.nextLine();
				String numberR = scanR.nextLine();
				int indexA = Integer.parseInt(numberA);
				int indexD = Integer.parseInt(numberD);
				int indexR = Integer.parseInt(numberR);
				ascendingQ[i] = indexA;
				descendingQ[i] = indexD;
				randomQ[i] = indexR;
				ascendingH[i] = indexA;
				descendingH[i] = indexD;
				randomH[i] = indexR;
				ascendingM[i] = indexA;
				descendingM[i] = indexD;
				randomM[i] = indexR;
				i++;
			}
		}
		catch(Exception Ex)
		{
			System.out.println("One Or All Of The Files MIgh Not Be Found"
					+ "Or You Have Entered Incorrect Name File Or order");
		}
	
		//QuickSort
		getTime(ascendingQ, outputfilename,"QuickAscending ",  0 );
		getTime(descendingQ, outputfilename, "QuickDescending ", 0);
		getTime(randomQ, outputfilename, "QuickRandom ", 0);
		System.out.print("-----------------------------------------------------------------------------------------");
		System.out.println();
		//HeapSort
		getTime(ascendingH, outputfilename,"HeapAscending ", 1 );
		getTime(descendingH, outputfilename, "HeapDescending ", 1);
		getTime(randomH, outputfilename, "HeapRandom ", 1);
		System.out.print("-----------------------------------------------------------------------------------------");
		System.out.println();
		//MergeSort
		getTime(ascendingM, outputfilename,"MergeAscending ", 2 );
		getTime(descendingM, outputfilename, "MergeDescending ", 2);
		getTime(randomM, outputfilename, "MergeRandom ", 2);
		System.out.print("-----------------------------------------------------------------------------------------");
		System.out.println();
		
		// write 9 files
		
		try
		{
			//QuickSort files
			File qa = new File(outputfilename+"QuickAsscend.txt");
			PrintWriter  qaw = new PrintWriter(qa);
			File qd = new File(outputfilename+"QuickDescend.txt");
			PrintWriter qdw = new PrintWriter(qd);
			File qr = new File(outputfilename+"QuickRandom.txt");
			PrintWriter  qrw = new PrintWriter(qr);
			
			//HeapSort files
			File ha = new File(outputfilename+"HeapAsscend.txt");
			PrintWriter  haw = new PrintWriter(ha);
			File hd = new File(outputfilename+"HeapDescend.txt");
			PrintWriter hdw = new PrintWriter(hd);
			File hr = new File(outputfilename+"HeapRandom.txt");
			PrintWriter  hrw = new PrintWriter(hr);
			
			//MergeSort files
			File ma = new File(outputfilename+"MergeAsscend.txt");
			PrintWriter  maw = new PrintWriter(ma);
			File md = new File(outputfilename+"MergeDescend.txt");
			PrintWriter mdw = new PrintWriter(md);
			File mr = new File(outputfilename+"MergeRandom.txt");
			PrintWriter  mrw = new PrintWriter(mr);
			
			//Create files
			qa.createNewFile();
			qd.createNewFile();
			qr.createNewFile();
			ha.createNewFile();
			hd.createNewFile();
			hr.createNewFile();
			ma.createNewFile();
			md.createNewFile();
			mr.createNewFile();
		
			//Enter Data to file.
			for(int q = 0 ; q < 10000 ; q++)
			{
				qaw.println(ascendingQ[q]);
				qdw.println(descendingQ[q]);
				qrw.println(randomQ[q]);
			}
			
			for(int h=0 ; h<10000 ; h++)
			{
				haw.println(ascendingH[h]);
				hdw.println(descendingH[h]);
				hrw.println(randomH[h]);
			}
			
			for( int m=0; m<10000; m++)
			{
				maw.println(ascendingM[m]);
				mdw.println(descendingM[m]);
				mrw.println(randomM[m]);
			}
			
			//close files
			qaw.close();
			qdw.close();
			qrw.close();
			haw.close();
			hdw.close();
			hrw.close();
			maw.close();
			mdw.close();
			mrw.close();

		} catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//check if files printed.
		System.out.println("Files Have Been Successfully Written!");
		System.out.println("Files Location: C:\\Users\\aghal\\eclipse-workspace\\PA4");
		System.out.print("-----------------------------------------------------------------------------------------");
	}
	
	//Get time for all advanced sorting alogrithms.
	private static void getTime(int[] ar, String outputfilename, String arrayname, int sort)
	{
		long s=0;
		long e=0;
		if(sort == 0)
		{
			s=  System.nanoTime();
			quickSort(ar,0,ar.length-1);
			e = System.nanoTime();
		}
		else if(sort == 1)
		{
			s=  System.nanoTime();
			heapSort(ar);
			e = System.nanoTime();
		}
		else if(sort == 2)
		{
			s=  System.nanoTime();
			sort(ar,0,ar.length-1);
			e = System.nanoTime();
		}
		
		long elapsedTime = e-s;
		System.out.println(arrayname+": "+elapsedTime+" (NanoSeconds).");
	}

	//MergeSort
	// Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
           L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
	
	
	//QuickSort
	 public static void quickSort(int ar[], int left, int right) 
	    {
	        if (left >= right) 
	        {
	            return;
	        }
	        int pivot = ar[left];
	        int leftPtr = left+1;
	        int rightPtr = right;
	        while(leftPtr <= rightPtr) 
	        {
	            while(leftPtr <= right && ar[leftPtr] <= pivot) 
	            {
	                leftPtr++;
	            }
	            while(rightPtr > left && ar[rightPtr] > pivot) 
	            {
	                rightPtr--;
	            }
	            if (leftPtr < rightPtr) 
	            {
	                int temp = ar[leftPtr];
	                ar[leftPtr] = ar[rightPtr];
	                ar[rightPtr] = temp;
	                leftPtr++;
	                rightPtr--;
	            }
	        }
	        int temp = ar[left];
	        ar[left] = ar[rightPtr];
	        ar[rightPtr] = temp;
	        quickSort(ar, left, rightPtr-1);
	        quickSort(ar, leftPtr, right);
	    }
	 
	//Heap sort
	 public static void buildheap(int []arr) 
	 {
		    /*
		     * As last non leaf node will be at (arr.length-1)/2 
		     * so we will start from this location for heapifying the elements
		     * */
		    for(int i=(arr.length-1)/2; i>=0; i--)
		    {
		           heapify(arr,i,arr.length-1);
		      }
		   }
		 
		   public static void heapify(int[] arr, int i,int size) { 
		      int left = 2*i+1;
		      int right = 2*i+2;
		      int max;
		      if(left <= size && arr[left] > arr[i])
		      {
		         max=left;
		      } else 
		      {
		         max=i;
		      }
		 
		      if(right <= size && arr[right] > arr[max]) 
		      {
		         max=right;
		      }
		      // If max is not current node, exchange it with max of left and right child
		      if(max!=i) {
		         exchange(arr,i, max);
		         heapify(arr, max,size);
		      }
		   }
		 
		   public static void exchange(int[] arr,int i, int j) 
		   {
		        int t = arr[i];
		        arr[i] = arr[j];
		        arr[j] = t; 
		   }
		 
		   public static int[] heapSort(int[] arr)
		   {
		      buildheap(arr);
		      int sizeOfHeap=arr.length-1;
		      for(int i=sizeOfHeap; i>0; i--) 
		      {
		         exchange(arr,0, i);
		         sizeOfHeap=sizeOfHeap-1;
		         heapify(arr, 0,sizeOfHeap);
		      }
		      return arr;
		   }
}
