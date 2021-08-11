package leetcode_aug;

public class ArrayOfDoubledPairs {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 16, 8, 2 };
		System.out.println(canReorderDoubled(arr));

	}

	public static boolean canReorderDoubled(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++)
			max = Math.max(max, Math.abs(arr[i]));

		int[] neg = new int[max + 1];
		int[] pos = new int[max + 1];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0)
				pos[arr[i]]++;
			else
				neg[Math.abs(arr[i])]++;
		}

		if (pos[0] % 2 != 0)
			return false;

		for (int i = 1; i < pos.length; i++) {
			if (pos[i] > 0) {
				if (i * 2 >= pos.length || pos[2 * i] < pos[i])
					return false;

				pos[2 * i] -= pos[i];
			}

			if (neg[i] > 0) {
				if (i * 2 >= neg.length || neg[2 * i] < neg[i])
					return false;

				neg[2 * i] -= neg[i];
			}
		}

		return true;
	}

}
