package sorts;

import java.util.Arrays;

public class Sorts {

	public static void main(String[] args) {
		
		final int[] unsorted = {2,7,10,6,1,4,9,5,3,8};
		//insertionSort(unsorted);
		//selectionSort(unsorted);
		bubbleSort(unsorted);
		
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
				int min = arr[imin];
				arr[imin] = arr[i];
				arr[i] = min;
			}
		}
	}
	
	public static void bubbleSort(int[] arr){
		boolean swapped = false;
		do{
			swapped = false;
			for(int i = 1; i< arr.length; i++){
				if(arr[i] < arr[i-1]){
					int arri = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = arri;
					swapped=true;
				}
			}
		}while(swapped);
	}
	
	public static void printArray(int[] arr){
		
		System.out.println(Arrays.toString(arr));
	}

}
