/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        //check if our list is empty or not
        if(head==null || head.next==null) return head;
        ListNode odd= head;
        ListNode even=head.next;
        ListNode evenHead=even;

        while(even != null && even.next != null){
            odd.next = even.next; //taking next of even as next of head node so we can skip the even part and join odd first
            odd = odd.next; //this will keep moving our odd forward
            even.next = odd.next; //connect even with next even
            even = even.next; //move even forward
        }
        odd.next = evenHead;
        return head;
    }
}