package leetcode_algo_selfstudy;

public class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = {0,4,0,3,1,0,2};
		moveZeroes(nums);
		for(int i = 0; i<nums.length;i++)
			System.out.println(nums[i]);
	}
	
	public static void moveZeroes(int[] nums) {
        int j = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
