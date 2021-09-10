package leetcode_algo_selfstudy;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int[] nums = {1,2,4};
		System.out.println(permute(nums));

	}
	
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getPermutations(res, new ArrayList<>(), nums);
        return res;
    }

    private static void getPermutations(List<List<Integer>> res, List<Integer> ls, int [] nums){
       if(nums.length == ls.size()){
          res.add(new ArrayList<>(ls));
       } 
       else {
          for(int i = 0; i < nums.length; i++){ 
             if(ls.contains(nums[i])) 
                 continue;
             ls.add(nums[i]);
             getPermutations(res, ls, nums);
             ls.remove(ls.size() - 1);
          }
       }
    }

}
