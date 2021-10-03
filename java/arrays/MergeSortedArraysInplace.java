package arrays;

import java.util.Arrays;

class MergeSortedArraysInplace {
	public static void main(String[] args) {
		int arr1[] = new int[] { 1,3,5,6,8,9};
		int arr2[] = new int[] { 0,2,4,7};
		
		merge(arr1, arr2, arr1.length, arr2.length);

		System.out.print(Arrays.toString(arr1));
		System.out.print(Arrays.toString(arr2));
	}

	public static void merge(int arr1[], int arr2[], int n, int m) {
		int i = 0;
		int temp = 0;

		while (arr1[n - 1] > arr2[0]) {
			if (arr1[i] > arr2[0]) {
				temp = arr1[i];
				arr1[i] = arr2[0];
				arr2[0] = temp;
				Arrays.sort(arr2);
			}
			i++;
		}
	}
}
