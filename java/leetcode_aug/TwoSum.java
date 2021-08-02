package leetcode_aug;

import java.util.HashMap;

/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] res = twoSum(nums,target);
		System.out.println(res[0] + " "+ res[1]);

	}

	private static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i<nums.length;i++){
            if(map.containsKey(nums[i])){
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            } else{
                map.put(target-nums[i],i);
            }
        }
        return res;
    }
}
