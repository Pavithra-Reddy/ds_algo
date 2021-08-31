package leetcode_algo_selfstudy;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 7, 8 };
		System.out.println(searchInsert(nums, 5));

	}

	public static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int first = 0;
        int last = nums.length-1;
        int mid;
        while(first <= last){
            mid =  first + ((last - first)/2);
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                first = mid+1;
            }
            else if(nums[mid] > target){
                last = mid-1;
            }
        }
        return first;
    }
	
}
