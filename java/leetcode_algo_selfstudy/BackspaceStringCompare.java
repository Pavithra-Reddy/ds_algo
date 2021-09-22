package leetcode_algo_selfstudy;

public class BackspaceStringCompare {

	public static void main(String[] args) {
		System.out.println(backspaceCompare("abc#ce#d", "abcdefg###"));
	}

	public static boolean backspaceCompare(String s, String t) {
		int i = s.length() - 1;
		int j = t.length() - 1;
		while (i >= 0 || j >= 0) {
			int c = 0;
			while (i >= 0) {
				if (s.charAt(i) == '#') {
					c++;
				} else {
					if (c > 0) {
						c--;
					} else {
						break;
					}
				}
				i--;
			}

			c = 0;
			while (j >= 0) {
				if (t.charAt(j) == '#') {
					c++;
				} else {
					if (c > 0) {
						c--;
					} else {
						break;
					}
				}
				j--;
			}

			if (i < 0 && j < 0) {
				return true;
			} else if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
				i--;
				j--;
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

}
