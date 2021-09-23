package leetcode_algo_selfstudy;

import leetcode_commons.TreeNode;

public class SubtreeOfAnotherTree {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode();
		int[] arr1 = {6,4,7,2,1};
		/*
		 6
		 /\
		4   7
		/\
		2 1
		*/
		root1 = root1.createTreeFromArray(arr1);
		
		TreeNode root2 = new TreeNode();
		int[] arr2 = {4,2,1};
		/*
		 4
		 /\
		2   1
		*/
		root2 = root2.createTreeFromArray(arr2);
		
		
		System.out.println(isSubtree(root1, root2));

	}
	
	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) 
            return false;
        if (isSame(root, subRoot)) 
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private static boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) 
            return true;
        
        if (root == null || subRoot == null) 
            return false;
        
        if (root.val != subRoot.val) 
            return false;
        
        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }

}
