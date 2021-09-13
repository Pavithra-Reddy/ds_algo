package leetcode_algo_selfstudy;

public class FirstAndLastPosition {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6, 6, 7, 7, 8, 8, 8, 9 };
		int[] res = searchRange(nums, 8);
		System.out.println(res[0] + " " + res[1]);

	}

	public static int[] searchRange(int[] nums, int target) {
		int[] res = { -1, -1 };

		int left = 0;
		int right = nums.length - 1;
		int ind = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				ind = mid;
				right = mid - 1;
			} else if (target > nums[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		res[0] = ind;

		ind = -1;
		left = 0;
		right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				ind = mid;
				left = mid + 1;
			} else if (target > nums[mid])
				left = mid + 1;
			else {
				right = mid - 1;
			}
		}

		res[1] = ind;

		return res;
	}

}
