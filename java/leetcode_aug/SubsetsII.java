package leetcode_aug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {

	public static void main(String[] args) {
		int[] arr = {1,2,2};
		System.out.println(subsetsWithDup(arr));

	}
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        Set<List<Integer>> res = new HashSet<List<Integer>>();
		int max = 1 << nums.length;
		for(int i = 0; i < max; i++) {
            List<Integer> subset = new ArrayList<Integer>();
            for(int k = i, j = 0; k > 0; k = k >> 1,j++) {
                if((k & 1) == 1) {
                    subset.add(nums[j]);
                }
            }
			res.add(subset);
		}
        
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        finalList.addAll(res);
        
		return finalList;
    }

}
