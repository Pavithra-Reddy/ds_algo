package leetcode_algo_selfstudy;

import leetcode_commons.TreeNode;

public class MergeBinaryTree {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode();
		int[] arr1 = {6,4,7,2};
		/*
		 6
		 /\
		4   7
		/
		2
		*/
		root1 = root1.createTreeFromArray(arr1);
		
		TreeNode root2 = new TreeNode();
		int[] arr2 = {1,1,1};
		/*
		 1
		 /\
		1   1
		*/
		root2 = root2.createTreeFromArray(arr2);
		
		
		TreeNode root = mergeTrees(root1, root2);
		root.preOrder(root);
		

	}

	public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) 
            return root2;       
        if(root2 == null) 
            return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
