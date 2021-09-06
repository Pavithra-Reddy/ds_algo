package leetcode_algo_selfstudy;

import leetcode_commons.TreeNode;

public class PopulateNextRightPointer {

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		int[] arr1 = {6,4,7,2,3,1,5};
		/*
		 6
		 /\
		4   7
		/\  /\
		2 3 1 5
		*/
		root = root.createTreeFromArray(arr1);
		root = connect(root);
		print(root);
	}

	public static TreeNode connect(TreeNode root) {
        if(root == null){
            return null;
        }
        
        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null)
                root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
        
        return root;
    }
	
	public static void print(TreeNode root)
	{
		if (root != null) {
			System.out.print(root.val + " ");
			if(root.next == null)
				System.out.print( "-> # ,");
			else 
				System.out.print("->" + root.next.val + " ,");
				
			print(root.left);
			print(root.right);
		}
	}
}
