package leetcode_algo_selfstudy;

import leetcode_commons.ListNode;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode head1 = new ListNode(10);
		head1.next = new ListNode(20);
		head1.next.next = new ListNode(30);
		head1.next.next.next = new ListNode(40);
		head1.next.next.next.next = new ListNode(50);
		
		ListNode head2 = new ListNode(10);
		head2.next = new ListNode(30);
		head2.next.next = new ListNode(50);
		head2.next.next.next = new ListNode(60);
		head2.next.next.next.next = new ListNode(70);
		
		ListNode res = mergeTwoLists(head1,  head2);
		
		while(res != null){
			System.out.print(res.val + " ");
			res = res.next;
        }

	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) 
            return l2;
		if(l2 == null) 
            return l1;
        
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
    }

}
