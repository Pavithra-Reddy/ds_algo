package leetcode_algo_selfstudy;

public class NumberOf1Bits {

	public static void main(String[] args) {
		System.out.println(hammingWeight(5));
		System.out.println(hammingWeight(63));

	}
	
	public static int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            n = n & (n-1);
            res++;
        }
        return res;
    }

}
