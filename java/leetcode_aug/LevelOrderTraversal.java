package leetcode_aug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import leetcode_aug_commons.Node;

public class LevelOrderTraversal {

	public static void main(String[] args) {
	    Node node3 = new Node(3, Arrays.asList(new Node(5, new ArrayList<Node>()), new Node(6, new ArrayList<Node>())));
	    Node node2 = new Node(2, new ArrayList<Node>());
	    Node node4 = new Node(4, new ArrayList<Node>());
		Node root = new Node(1, Arrays.asList(node3, node2, node4));
		
		System.out.println(levelOrder(root));

	}
	public static List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> levelOrders = new ArrayList<List<Integer>>();
		if(root == null){
			return levelOrders;
		}
		List<Integer> level = new ArrayList<Integer>(); 
		level.add(root.val);

		List<Node> parent = new ArrayList<Node>();
		parent.add(root);

		while(!parent.isEmpty()){
			levelOrders.add(level);
			level = new ArrayList<Integer>();
			List<Node> children = new ArrayList<Node>();
			for(Node p : parent){
				List<Node> currChildren = p.children;
				for(Node c: currChildren){
					level.add(c.val);
				}
				children.addAll(currChildren);
			}
			parent = children;
		}

		return levelOrders;
	}


}
