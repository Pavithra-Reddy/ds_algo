package leetcode_aug;

public class SumOfSquareNumbers {

	public static void main(String[] args) {
		System.out.println(judgeSquareSum(58));

	}
	
	//Fermat Theorem - Any positive number n is expressible as a sum of two squares if and only if the prime factorization of n, every prime of the form (4k+3) occurs an even number of times.
	public static boolean judgeSquareSum(int c) {
        if (c == 0 || c == 1)
            return true;

        while (c % 2 == 0) {
            c = c >> 1;
        }

        for (int i = 3; i * i <= c; i += 2) {
            int k = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    k++;
                    c /= i;
                }
                if (i % 4 == 3 && (k & 1) == 1)
                    return false;
            }
        }
        return c % 4 != 3;
    }

}
