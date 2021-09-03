package leetcode_algo_selfstudy;

import leetcode_commons.ListNode;

public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);
		ListNode res = removeNthFromEnd(head,1);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
		

	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        while(n != 0){
            p1 = p1.next;
            n--;
        }
        
        if(p1 == null){
            return head.next;
        }
        
        while(p1 != null){
            p1 = p1.next;
            if(p1 == null){
                p2.next = p2.next.next;
                break;
            }
            p2 = p2.next;
            
        }
        
        return head;
    }

}
