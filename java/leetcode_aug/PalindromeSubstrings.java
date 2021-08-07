package leetcode_aug;

public class PalindromeSubstrings {

	public static void main(String args[]) {
		System.out.println(minCut("abcbd"));
	}

	public static int minCut(String s) {
		int n = s.length();
		int[] C = new int[n];
		boolean[][] P = new boolean[n][n]; 

		for (int i = 0; i < n; i++) {
			P[i][i] = true;
		}

		int  k;
		for (int L = 2; L <= n; L++) {
			for (int i = 0; i < n - L + 1; i++) {
				k = i + L - 1; 
				if (L == 2)
					P[i][k] = (s.charAt(i) == s.charAt(k));
				else
					P[i][k] = (s.charAt(i) == s.charAt(k)) && P[i + 1][k - 1];
			}
		}

		for (int i = 0; i < n; i++) {
			if (P[0][i] == true)
				C[i] = 0;
			else {
				C[i] = Integer.MAX_VALUE;
				for (int j = 0; j < i; j++) {
					if (P[j + 1][i] == true && 1 + C[j] < C[i]) {
						C[i] = 1 + C[j];
					}	
				}
			}
		}

		return C[n - 1];
	}

}
