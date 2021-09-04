package leetcode_algo_selfstudy;

public class PermutationInString {

	public static void main(String[] args) {
		System.out.println(checkInclusion("red","spiderman"));
	}
	
	public static boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        
        if (n1 > n2) 
            return false;
        
        int[] charCount = new int[26];
        
        for (int i = 0; i < n1; i++) {
            charCount[s1.charAt(i) - 'a']++;
            charCount[s2.charAt(i) - 'a']--;
        }
        
        if (isFound(charCount)) 
            return true;
        
        for (int i = n1; i < n2; i++) {
            charCount[s2.charAt(i) - 'a']--;
            charCount[s2.charAt(i - n1) - 'a']++;
            if(isFound(charCount)) 
                return true;
        }
        
        return false;
    }
    
    private static boolean isFound(int[] charCount) {
        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) 
                return false;
        }
        return true;
    }

}
