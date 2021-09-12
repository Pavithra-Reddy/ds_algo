package leetcode_algo_selfstudy;

public class SingleNumber {

	public static void main(String[] args) {
		int[] nums = {1,4,6,1,5,5,4};
		System.out.println(singleNumber(nums));

	}

	public static int singleNumber(int[] nums) {
		int a = 0;
		for(int i = 0; i < nums.length; i++) {
			a = a^nums[i];
		}
		return a;
		
	}

}
