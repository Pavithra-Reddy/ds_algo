package leetcode_aug;

public class DecodeWays {

	public static void main(String[] args) {
		System.out.println(numDecodings("226"));

	}

	public static int numDecodings(String s) {
        int len = s.length();

        if(len == 0) {
            return 0;
        }
        
        int[] count = new int[len + 1];
        count[len] = 1;
        count[len - 1] = s.charAt(len - 1) != '0' ? 1 : 0;
        
        for(int i = len - 2; i >= 0; i--) {
            if(s.charAt(i) != '0')  {
            	count[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? count[i + 1] + count[i + 2] : count[i + 1];
            }
        }
        
        return count[0];
    }
}
