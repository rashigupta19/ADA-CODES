package Sorting;
import java.util.Arrays;   
import java.util.Collections;
import java.lang.System;

import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		                              //Random array generation
		Random rd = new Random(); 
		int[] arr = new int[10000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(1000); 	}


		long start = System.nanoTime();
		sort(arr, 0, arr.length-1);
		long end = System.nanoTime();

		                               // ascending order
		long start1 = System.nanoTime();
		sort(arr, 0, arr.length-1);
		long end1 = System.nanoTime();

		                               //descending order
		int b[] = new int[arr.length]; 
		for (int i=0; i<arr.length; i++) 
			b[i] = arr[arr.length-i-1];

		long start2 = System.nanoTime();
		sort(b, 0, b.length-1);
		long end2 = System.nanoTime();

		                               // same number
		int[] c =new int[10000];
		for(int i=0;i<c.length;i++) {
			c[i]=505;
		}

		long start3 = System.nanoTime();
		sort(c, 0, c.length-1);
		long end3 = System.nanoTime();


		System.out.println("Time taken by random array= "+(end - start) + " ns"); 
		System.out.println("Time taken by ascending order array= "+(end1 - start1) + " ns"); 
		System.out.println("Time taken by descending order array= "+(end2 - start2) + " ns"); 
		System.out.println("Time taken by same no. array= "+(end3 - start3) + " ns"); 



	}

	static void merge(int arr[], int beg, int mid, int end)  
	{  

		int l = mid - beg + 1;  
		int r = end - mid;  

		int LeftArray[] = new int [l];  
		int RightArray[] = new int [r];  

		for (int i=0; i<l; ++i) {  
			LeftArray[i] = arr[beg + i];  }

		for (int j=0; j<r; ++j) {  
			RightArray[j] = arr[mid + 1+ j];  }


		int i = 0, j = 0;  
		int k = beg;  
		while (i<l&&j<r)  
		{  
			if (LeftArray[i] <= RightArray[j])  
			{  
				arr[k] = LeftArray[i];  
				i++;  
			}  
			else  
			{  
				arr[k] = RightArray[j];  
				j++;  
			}  
			k++;  
		}  
		while (i<l)  
		{  
			arr[k] = LeftArray[i];  
			i++;  
			k++;  
		}  

		while (j<r)  
		{  
			arr[k] = RightArray[j];  
			j++;  
			k++;  
		}  
	}  

	static void sort(int arr[], int beg, int end)  
	{  
		if (beg<end)  
		{  
			int mid = (beg+end)/2;  
			sort(arr, beg, mid);  
			sort(arr , mid+1, end);  
			merge(arr, beg, mid, end);  
		}  
	}  

}
