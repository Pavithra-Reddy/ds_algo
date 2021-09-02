package leetcode_aug;

import leetcode_commons.TreeNode;

public class MaximumProductSubtree {
	public static long res = 0;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		int[] arr = {6,1,1,2};
		/*
		 6
		 /\
		1   1
		/
		2
		*/
		root = root.createTreeFromArray(arr);

		System.out.println(maxProduct(root));

	}
	
    public static int maxProduct(TreeNode root) {
        final long total_sum = sum(root, 0);
        sum(root, total_sum);
        return (int) (res % 1000000007);
    }
    
    public static int sum(TreeNode node, long total_sum) {
        if (node == null) 
            return 0;
        int left_subtree_sum = sum(node.left, total_sum);
        int right_subtree_sum = sum(node.right, total_sum);
        final int subtree_sum = left_subtree_sum + right_subtree_sum + node.val;
        res = Math.max(res, subtree_sum * (total_sum - subtree_sum));
        return subtree_sum;
    }

}
