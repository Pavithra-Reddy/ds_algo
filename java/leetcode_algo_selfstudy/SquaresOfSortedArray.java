package leetcode_algo_selfstudy;

public class SquaresOfSortedArray {

	public static void main(String[] args) {
		int[] nums = {-7,-6,-5,-4,0,1,2};
		nums = sortedSquares(nums);
		for(int i = 0; i<nums.length;i++)
			System.out.println(nums[i]);
	}
	public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        int j = n - 1;
        for (int k = n - 1; k >= 0; k--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[k] = nums[i] * nums[i];
                i++;
            } else {
                res[k] = nums[j] *nums[j];
                j--;
            }
        }
        return res;
    }

}
