package leetcode_aug;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));

	}

	public static String minWindow(String s, String t) {
		int m = s.length();
		int n = t.length();

        if(m < n){
            return "";
        }
		
		int countArr[] = new int[127];
		for (int i = 0; i < t.length(); i++)
			countArr[t.charAt(i)]++;

		int start = 0;
		int end = m;
		int i = 0;
		int j = 0;
		int c = n;
		
		while(i < m && j < m) {
			
			if (c > 0) {
				if (--countArr[s.charAt(j)] >= 0) {
					c--;
				}
			} 
			else if (countArr[s.charAt(i - 1)]++ >= 0) {
				c++;
			}
			
			if (c == 0 && (j - i) < (end - start)) {
				start = i;
				end = j;
			}
			
			if(c > 0) {
				j++;
			}
			else {
				i++;
			}
		}
		
		return end == m ? "" : s.substring(start, end + 1);
	}

}
