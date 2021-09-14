package leetcode_algo_selfstudy;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(search(nums, 6));

	}

	public static int search(int[] nums, int target) {
		int n = nums.length;
		int first = 0;
		int last = n - 1;
		
		while (first <= last) {
			int mid =  first + ((last - first)/2);
			if (nums[mid] == target)
				return mid;
				
			if(nums[first] <= nums[mid]) {
	            if(target < nums[mid] && target >= nums[first]) {
	                last = mid - 1;
	            } else {
	                first = mid + 1;
	            }
	        }
	        
	        
	        if(nums[last] >= nums[mid]) {
	            if(target > nums[mid] && target <= nums[last]) {
	                first = mid + 1;
	            } else {
	                last = mid - 1;  
	            }
	        }
		}
		return -1;
	}

}
