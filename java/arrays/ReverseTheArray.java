package arrays;

import java.util.Random;

public class ReverseTheArray {

	public static void reverseArray(int[] arr) {
		int temp, n = arr.length;
		for(int i = 0; i < n/2; i++) {
			temp = arr[i];
			arr[i] = arr[n-1-i];
			arr[n-1-i] = temp;
		}
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		int size = rand.nextInt(10);
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = rand.nextInt(100);
		}
		
		System.out.println("Before");
		printArray(arr);
		reverseArray(arr);
		System.out.println("After");
		printArray(arr);
	}
	
	private static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
