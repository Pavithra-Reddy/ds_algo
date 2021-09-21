package leetcode_algo_selfstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int n = nums.length;
		if (n < 3)
			return res;

		Arrays.sort(nums);
		for (int i = 0; i < n - 2; i++) {
			if (nums[i] > 0)
				break;
			if (i == 0 || nums[i] != nums[i - 1]) {
				int low = i + 1;
				int high = n - 1;
				int currSum = 0 - nums[i];
				while (low < high) {
					if (nums[low] + nums[high] == currSum) {
						res.add(Arrays.asList(nums[i], nums[low], nums[high]));
						
						while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
						
						while (low < high && nums[high] == nums[high - 1]){
                            high--;
                        }
						
						low++;
						high--;
						
					} else if (nums[low] + nums[high] < currSum) {
						low++;
                    } else {
						high--;
                    }
				}
			}
		}
		return res;
	}

}
