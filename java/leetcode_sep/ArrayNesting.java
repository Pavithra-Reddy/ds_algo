package leetcode_sep;

public class ArrayNesting {

	public static void main(String[] args) {
		int[] nums = {5,4,0,3,1,6,2};
		System.out.println(arrayNesting(nums));
	}
	
	public static int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) { 
            if (nums[i] != -1) { 
                int j = nums[i]; 
                int count = 0;

                while(nums[j] != -1) { 
                    int tmp = j; 
                    j = nums[j]; 
                    nums[tmp] = -1;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        
        return res;
    }

}
