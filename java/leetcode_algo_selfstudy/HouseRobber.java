package leetcode_algo_selfstudy;

public class HouseRobber {

	public static void main(String[] args) {
		int[] nums = {2,5,3,6,9};
		System.out.println(rob(nums));

	}
	
	public static int rob(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = a;
            a = Math.max(b + nums[i], a);
            b = temp;
        }
        return a;
    }

}
