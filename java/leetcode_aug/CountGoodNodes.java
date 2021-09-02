package leetcode_aug;

import leetcode_commons.TreeNode;

public class CountGoodNodes {

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		int[] arr = { 5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 0, 0, 5, 1 };
		root = root.createTreeFromArray(arr);
		System.out.println(goodNodes(root));
	}

	public static int goodNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return dfs(root, root.val);
	}

	public static int dfs(TreeNode node, int max) {
		if (node == null) {
			return 0;
		}
		int count = 0;
		int val = node.val;
		if (val >= max) {
			max = val;
			count = 1;
		}
		count += dfs(node.left, max);
		count += dfs(node.right, max);
		return count;
	}

}
