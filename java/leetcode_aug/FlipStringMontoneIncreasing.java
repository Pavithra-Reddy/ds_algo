package leetcode_aug;

public class FlipStringMontoneIncreasing {

	public static void main(String[] args) {
		System.out.println(minFlipsMonoIncr("100111111101011"));

	}
	
	public static int minFlipsMonoIncr(String s) {
        int n = s.length();
        int arr1[] = new int[n+1];
        int arr2[] = new int[n+1];
        
        arr1[0] = s.charAt(0) - '0';
        arr2[n-1] =  '1' - s.charAt(n-1);
        
        for(int i = 1; i < n; i++){
            arr1[i] = arr1[i-1] + (s.charAt(i) - '0');
        }
        for(int i = n-2; i >= 0; i--){
            arr2[i] =  arr2[i+1] + ('1' - s.charAt(i));
        }
        
        int min = arr2[0];
        
        for(int i = 1; i <= n; i++){
            min = Math.min(min,(arr1[i-1] + arr2[i]));
        }
        
        return min;
    }

}
