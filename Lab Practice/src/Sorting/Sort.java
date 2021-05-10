package Sorting;
import java.lang.System;
import java.util.Random;
import java.util.Arrays;
public class Sort {


	void insertionSort(int arr[]) 
	{ long start = System.currentTimeMillis();
	int n = arr.length; 
	for (int i = 1; i < n; ++i) { 
		int key = arr[i]; 
		int j = i - 1; 

		while (j >= 0 && arr[j] > key) { 
			arr[j + 1] = arr[j]; 
			j = j - 1; 
		} 
		arr[j + 1] = key; 
	}

	long end = System.currentTimeMillis(); 
	System.out.println("Time taken by insertion sort " + 
			(end - start) + " ms"); 
	} 
	
	

	void selectionSort(int[] arr){ 
		long start = System.currentTimeMillis();
		for (int i = 0; i < arr.length - 1; i++)  
		{  
			int index = i;  
			for (int j = i + 1; j < arr.length; j++){  
				if (arr[j] < arr[index]){  
					index = j;  
				}  
			}  
			int smallerNumber = arr[index];   
			arr[index] = arr[i];  
			arr[i] = smallerNumber;  
		}
		long end = System.currentTimeMillis(); 
		System.out.println("Time taken by selection sort " + 
				(end - start) + " ms"); 
	} 


	void bubbleSort(int[] a) {
		long start = System.currentTimeMillis();
		int n = a.length; 
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-i-1; j++) 
				if (a[j] > a[j+1]) 
				{ 
					int temp = a[j]; 
					a[j] = a[j+1]; 
					a[j+1] = temp; 
				} 
		} 
		long end = System.currentTimeMillis();
		System.out.println("Time taken by bubble sort " + 
				(end - start) + " ms"); 
	}

	
	
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");} 

		System.out.println(); 
	} 



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rd = new Random(); 
		int[] arr = new int[100000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(1000); 	}

		int arr1[]=Arrays.copyOf(arr, 100000);
		int arr2[]=Arrays.copyOf(arr, 100000);

		System.out.println();

		Sort ob = new Sort(); 
		ob.insertionSort(arr); 
	//	ob.printArray(arr); 
		System.out.println();

		ob.selectionSort(arr1);
	//	ob.printArray(arr1); 
		System.out.println();

		ob.bubbleSort(arr2);
	//	ob.printArray(arr2); 

	}

}
