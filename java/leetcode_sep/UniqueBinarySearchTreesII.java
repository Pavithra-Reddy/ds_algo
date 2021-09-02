package leetcode_sep;

import java.util.ArrayList;
import java.util.List;

import leetcode_commons.TreeNode;

public class UniqueBinarySearchTreesII {

	public static void main(String[] args) {
		List<TreeNode> treeList = generateTrees(3);
		for(TreeNode root : treeList) {
			root.preOrder(root);
			System.out.println(" ");
		}

	}

	public static List<TreeNode> generateTrees(int n) {
        return construct(1, n);
    }
    
    public static List<TreeNode> construct(int first, int last){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(first > last){
            res.add(null);
        } else if (first == last) {
            res.add(new TreeNode(first));
        } else {
            for(int i = first; i <= last; i++){
                List<TreeNode> lefttree = construct(first, i-1);
                List<TreeNode> righttree = construct(i+1, last);
                for(TreeNode lt: lefttree){
                    for(TreeNode rt: righttree){
                        TreeNode node = new TreeNode(i);
                        node.left=lt;
                        node.right=rt;
                        res.add(node);
                    }
                }
            }
        }
        return res;
    }
}
