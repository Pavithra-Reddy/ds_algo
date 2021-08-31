package leetcode_aug;

public class RotatedSortedArrayMinimum {

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		
		System.out.println(findMin(nums));

	}

	public static int findMin(int[] nums) {
        int first = 0;
        int last = nums.length-1;
        int mid;
        
        while(first <= last){
            
            if(nums[first] < nums[last] || first == last)
                return nums[first];
            
            mid =  first + ((last - first)/2);
            
            if (mid > first && nums[mid] < nums[mid-1])
                return nums[mid];
            
            if (mid < last && nums[mid+1] < nums[mid])
                return nums[mid+1];
            
            if (nums[last] > nums[mid])
                last = mid-1;
            else
                first = mid+1;
        }
        
        return nums[first];
    }
}
