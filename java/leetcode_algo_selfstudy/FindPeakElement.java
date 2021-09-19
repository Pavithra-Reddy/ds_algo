package leetcode_algo_selfstudy;

public class FindPeakElement {

	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[] {1,2,3,5,2,1,6,7}));

	}

	public static int findPeakElement(int[] nums) {
        for(int i = 1; i < nums.length; i ++)
        {
            if(nums[i] < nums[i-1])
            {
                return i-1;
            }
        }
        return nums.length-1;
    }
}
