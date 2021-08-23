package leetcode_aug;

import leetcode_aug_commons.TreeNode;

public class TwoSumIV {

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		int[] arr = {6,4,7,2};
		/*
		 6
		 /\
		4   7
		/
		2
		*/
		root = root.createTreeFromArray(arr);

		System.out.println(findTarget(root,9));
	}


	public static boolean findTarget(TreeNode root, int k) {
		if (root == null || root.left == null && root.right == null)
			return false;

		TreeNode temp = root;
		return traverseRoot(root, k, temp);
	}

	public static boolean traverseRoot(TreeNode root, int k, TreeNode temp) {
		if (root == null)
			return false;

		TreeNode res = findTwoSum(temp, k - root.val);
		if (res != null && res != root)
			return true;

		return traverseRoot(root.left, k, temp) || traverseRoot(root.right, k, temp);
	}

	public static TreeNode findTwoSum(TreeNode root, int k) {
		if (root == null)
			return null;

		if (root.val == k)
			return root;
		else if (root.val < k)
			return findTwoSum(root.right, k);
		else
			return findTwoSum(root.left, k);
	}
}
