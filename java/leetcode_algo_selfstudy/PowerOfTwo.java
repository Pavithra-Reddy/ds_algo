package leetcode_algo_selfstudy;

public class PowerOfTwo {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(54));
		System.out.println(isPowerOfTwo(64));

	}
	
	public static boolean isPowerOfTwo(int n) {
        if(n <= 0) 
            return false;
        return (n & (n-1)) == 0;
    }

}
