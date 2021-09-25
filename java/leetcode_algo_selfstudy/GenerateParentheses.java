package leetcode_algo_selfstudy;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public static void main(String args[]) {
		System.out.println(generateParenthesis(2));
    }
	
	public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        getCombinations(res,n,0,"");
        return res;
    }
    
    private static void getCombinations(List<String> res, int leftPar, int rightPar, String comb) {
        if (leftPar == 0 && rightPar == 0) {
            res.add(comb);
            return;
        }
        if (leftPar > 0) 
            getCombinations(res,leftPar - 1, rightPar + 1, comb + "(");
        if (rightPar > 0) 
            getCombinations(res,leftPar, rightPar - 1, comb + ")");
    }
}
