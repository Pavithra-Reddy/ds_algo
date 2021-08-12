package leetcode_aug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(strs));
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String,List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            List<String> ls = map.get(sorted);
            if (ls == null) {
                ls = new ArrayList<>();
                map.put(sorted, ls);
                res.add(ls);
            }
            ls.add(s);
        }
        
        return res;
    }
}
