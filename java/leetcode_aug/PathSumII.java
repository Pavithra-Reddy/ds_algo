package leetcode_aug;

import java.util.ArrayList;
import java.util.List;

import leetcode_commons.TreeNode;

 
public class PathSumII {
	public static void main(String args[]) {
		TreeNode root = new TreeNode();
		int[] arr = {5,4,8,11,0,13,4,7,2,0,0,0,0,5,1};
		root = root.createTreeFromArray(arr);

		System.out.println(pathSum(root, 22));
	}

	public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        pathSumHelper(root, targetSum, new ArrayList<Integer>(), res);
        return res;
    }
    
    public static void pathSumHelper(TreeNode root, int targetSum, List<Integer> subList, List<List<Integer>> res) {
        if(root == null){
            return;
        }
        targetSum -= root.val;
        subList.add(root.val);
        
        if(root.left == null && root.right == null){
            if(targetSum == 0){
                List<Integer> currList = new ArrayList<>();
                currList.addAll(subList);
                res.add(currList);
            }
            subList.remove(subList.size() - 1);
            return;
        }
        pathSumHelper(root.left, targetSum, subList, res);
        pathSumHelper(root.right, targetSum, subList, res);
        
        subList.remove(subList.size() - 1);
    }
}
