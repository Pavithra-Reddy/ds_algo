package leetcode_algo_selfstudy;

public class RightRotateArray {

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2,3};
		rotate(nums, 4);
		for(int i = 0; i<nums.length;i++)
			System.out.println(nums[i]);

	}
	
	public static void rotate(int[] nums, int k) {
        int n  = nums.length;
        k = k%n;
        if (k == 0 || n < 2) {
            return;
        }
 
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-k-1);
        reverse(nums, 0, n-1);
    }
    
    private static void reverse(int arr[], int i, int j)
    {
        int temp = 0;       
        while(i < j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}
