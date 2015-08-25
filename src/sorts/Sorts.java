package sorts;

import java.util.Arrays;

public class Sorts {

	public static void main(String[] args) {
		
		final int[] unsorted = {2,7,10,6,3,4,9,5,1,8};
		//insertionSort(unsorted);
		selectionSort(unsorted);
		//bubbleSort(unsorted);
		//quickSort(unsorted);
		//mergeSort(unsorted);
		
		printArray(unsorted);

	}
	
	public static void insertionSort(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			int toSort = arr[i];
	    	int j = i;
	    	while (j > 0 && arr[j - 1] > toSort) {
	        	arr[j] = arr[j - 1];
	        	j--;
	        }
	        arr[j] = toSort;
	     }
	}
	
	public static void selectionSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			int imin = i;
			for(int j = i+1; j < arr.length; j++){
				if(arr[j]<arr[imin]){
					imin = j;
				}
			}
			
			if(imin != i){
				swap(arr,imin,i);
			}
		}
	}
	
	public static void bubbleSort(int[] arr){
		boolean swapped = false;
		do{
			swapped = false;
			for(int i = 1; i< arr.length; i++){
				if(arr[i] < arr[i-1]){
					swap(arr, i, i-1);
					swapped=true;
				}
			}
		}while(swapped);
	}
	
	public static void quickSort(int arr[]){
		quickSort(arr,0,arr.length-1);
	}
	
	private static void quickSort(int arr[], int left, int right) {
		
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	      
	      
	}
	
	static int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int pivot = arr[(left + right) / 2];
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	            	  swap(arr,i,j);
	                  i++;
	                  j--;
	                  
	            }
	      };

	      return i;
	}
	
	
	public static void mergeSort(int[] arr)
	{
		mergeSort(arr, 0, arr.length-1);
	}
	
	private static void mergeSort(int[] arr, int left, int right)
	{
		if (left < right)
		{
			int mid = (left + right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}
	
	public static void merge(int[] data, int left, int mid, int right)
	{
		int[] A;
		A = new int[mid-left+2];

		int[] B;
		B = new int[right-mid+1];

		int i;

		// Copy the first half into A
		for(i = left; i <= mid; i++)
			A[i-left] = data[i];

		// Place infinity in the last slot of A
		A[A.length-1] = Integer.MAX_VALUE;

		// Copy the second half into B
		for(i = mid+1; i <= right; i++)
			B[i-(mid+1)] = data[i];

		// Place infinity in the last slot of B
		B[B.length-1] = Integer.MAX_VALUE;
		
		i = 0;		// index for A
		int j = 0;	// index for B
		int l;

		// A and B are merged back into data
		for(l = left; l <= right; l++)
		{
			if(A[i] <= B[j])
			{
				data[l] = A[i];
				i++;
			}
			else
			{
				data[l] = B[j];
				j++;
			}
		}		


	}

	//Common Methods

	public static void swap(int[] arr, int x, int y)
	{
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	} 
	
	public static void printArray(int[] arr){
		
		System.out.println(Arrays.toString(arr));
	}

}
