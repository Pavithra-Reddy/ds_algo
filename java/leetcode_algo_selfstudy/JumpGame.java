package leetcode_algo_selfstudy;

public class JumpGame {

	public static void main(String[] args) {
		System.out.println(canJump(new int[] {2,3,1,1,4}));
	}
	
	 public static boolean canJump(int[] nums) {
        int max = nums.length - 1;
        for (int i = nums.length - 1; i >= 0;i--){
            if (nums[i] + i >= max) 
                max = i;
        }
        if(max == 0)
            return true;
        
        return false;
    }

}
