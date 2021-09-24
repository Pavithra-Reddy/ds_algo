package leetcode_algo_selfstudy;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));

	}
	
	public static int minSubArrayLen(int target, int[] nums) {
      int i = 0;
      int j = 0;
      int sum = 0;
      int min = Integer.MAX_VALUE;

      while (j < nums.length) {
        sum = sum + nums[j];
        j++;
        while (sum >= target) {
          min = Math.min(min, j - i);
          sum = sum - nums[i++];
        }
      }

      return min == Integer.MAX_VALUE ? 0 : min;
    }

}
