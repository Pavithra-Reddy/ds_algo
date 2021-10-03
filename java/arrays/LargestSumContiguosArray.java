package arrays;

public class LargestSumContiguosArray {

	public static void main(String[] args) {
		int[] arr = { 1, -3, -2, 5, -2, 10 };
		System.out.println(maxSubArraySum(arr));
	}

	public static int maxSubArraySum(int arr[]) {
		int n = arr.length;
		int max = Integer.MIN_VALUE;
		int curr = 0;

		for (int i = 0; i < n; i++) {
			curr = curr + arr[i];
			
			if (curr > max)
				max = curr;
			
			if (curr < 0)
				curr = 0;
		}
		return max;
	}

}
