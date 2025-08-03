class Solution {
	public void reorderList(ListNode head) {
		if(head==null || head.next==null) return;
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode sec = rev(slow.next);
		slow.next=null;
		merge(head,sec);
	}
	ListNode rev(ListNode head) {
		ListNode cur= head;
		ListNode prev = null;
		ListNode nxt;
		while(cur!=null) {
			nxt=cur.next;
			cur.next = prev;
			prev = cur;
			cur=nxt;
		}
		return prev; //new head
	}
	void merge(ListNode list1, ListNode list2) {
		while(list1!=null && list2!=null) {
			ListNode temp1 = list1.next;
			ListNode temp2 = list2.next;
			list1.next = list2;
			if(temp1==null) break;
			list2.next=temp1;
			list1=temp1;
			list2 = temp2;
		}
	}
}