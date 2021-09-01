package leetcode_algo_selfstudy;

public class TwoSumIISorted {

	public static void main(String[] args) {
		int[] nums = {1,4,5,7,9};
		int[] res = twoSum(nums,8);
		System.out.println(res[0] + " " + res[1]);

	}
	
	public static int[] twoSum(int[] numbers, int target) {
        int f=0;
        int l = numbers.length - 1;
        
        while(numbers[f]+numbers[l] != target)
        {
            if(numbers[f]+numbers[l] > target)
                l--;
            else f++;
        }
        return new int[]{f+1,l+1};
    }

}
