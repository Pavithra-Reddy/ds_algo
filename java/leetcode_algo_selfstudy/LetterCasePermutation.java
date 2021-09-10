package leetcode_algo_selfstudy;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

	public static void main(String[] args) {
		System.out.println(letterCasePermutation("a3d"));

	}

	public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        char[] charArr = s.toLowerCase().toCharArray();
        getAllPermutations(charArr, 0, res);
        return res;
    }
    
    private static void getAllPermutations(char[] charArr, int i, List<String> res){
        if(charArr.length == i){
            res.add(new String(charArr));
            return;
        }
        
        getAllPermutations(charArr, i + 1, res);
        if(charArr[i] >= 'a' && charArr[i] <= 'z') {
            charArr[i] = Character.toUpperCase(charArr[i]);
            getAllPermutations(charArr, i + 1, res);
            charArr[i] = Character.toLowerCase(charArr[i]);
        }
    }
}
