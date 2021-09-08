package leetcode_algo_selfstudy;

import leetcode_commons.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);
		
		ListNode res = reverseList(head);
		
		while(res != null){
			System.out.print(res.val + " ");
			res = res.next;
        }

	}
	
	public static ListNode reverseList(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode n = head.next;
            head.next = res;
            res = head;
            head = n;
        }
        return res;
    }

}
