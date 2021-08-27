package leetcode_aug;

public class LongestUncommonSubsequenceII {

	public static void main(String[] args) {
		String[] strs = {"abdc","asc","tee"};
		System.out.println(findLUSlength(strs));
	}

	private static int findLUSlength(String[] strs) {
        int res = -1;
        int j = 0;
        int n = strs.length;
        for (int i = 0; i < n; i++){
            if (strs[i].length() > res) {
                for (j = 0; j < n; j++){
                    if (i != j && checkSubs(strs[i], strs[j])) 
                        break;
                }
                if(j == n) 
                    res = Math.max(res, (int)strs[i].length());
            }
        }
        return res;
    }
    
    private static boolean checkSubs(String subs, String str) {
        int j = 0;
        int i = 0;
        while (i < str.length() && j < subs.length()) {
			if (str.charAt(i) == subs.charAt(j))
				j++;
            i++;
		}
        return j == subs.length();
    }

}
