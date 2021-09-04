package leetcode_algo_selfstudy;

public class LongestSubstringWithoutRepeatingChars {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abaghjklybba"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        int[] charIndex = new int[128];
        int max = 0;
        int i = 0;
        int j = 0;
        while(i < s.length()){
            if(charIndex[s.charAt(i)] != 0){
                max = Math.max((i-j),max);
                j = Math.max(charIndex[s.charAt(i)],j);
            }
            charIndex[s.charAt(i)] = i+1;
            i++;
        }
        return Math.max((i-j),max);
    }

}
