package leetcode_algo_selfstudy;

import java.util.HashMap;

public class LongSubseqAtmostKDistinct {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("abcbbcdddd", 3));
	}
	
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int max = 0;
        int n = s.length();
        int i = 0, j = 0;
        while(i < n && j < n){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            
            if(map.size() > k){
                while(map.size() > k  && i < n){
                    map.put(s.charAt(i), map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i)) == 0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }

            if(map.size() <= k){
                max = Math.max(max, j - i + 1);
            }

            j++;
        }
        
        return max;
    }

}
