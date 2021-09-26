package leetcode_algo_selfstudy;

public class SubarrayProductLessThanK {

	public static void main(String[] args) {
		System.out.println(numSubarrayProductLessThanK(new int[] {10,5,2,6}, 100));

	}

	public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) 
           return 0;
        
        int prod = 1;
        int res = 0;
       
        int l = 0;
        int r = 0;
        while(r < nums.length) {
           prod = prod * nums[r];
           while(prod >= k) {
               prod = prod / nums[l];
               l++;
           }
           res = res + (r - l + 1);
           r++;
        } 
        return res;
    }
}
