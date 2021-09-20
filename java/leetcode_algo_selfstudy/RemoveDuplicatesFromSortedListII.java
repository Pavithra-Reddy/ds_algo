package leetcode_algo_selfstudy;

import leetcode_commons.ListNode;

public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(30);
		head.next.next.next.next = new ListNode(50);
		
		ListNode res = deleteDuplicates(head);
		
		while(res != null){
			System.out.print(res.val + " ");
			res = res.next;
        }

	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		
		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode prev = temp;
		ListNode curr = head;
		
		while (curr != null) {
			while (curr.next != null && curr.val == curr.next.val) {
				curr = curr.next;
			}
			
			if (prev.next == curr) {
				prev = prev.next;
			} else {
				prev.next = curr.next;
			}
			
			curr = curr.next;
		}
		
		return temp.next;
	}

}
