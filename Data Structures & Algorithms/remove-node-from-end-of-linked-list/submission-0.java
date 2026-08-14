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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null || head.next == null) return null;

        ListNode temp=head;
        int count=1;
        while (count < n) {
            temp=temp.next;
            count++;
        }
        if (temp.next.next != null) {
            temp.next=temp.next.next;
        }
        else temp.next=null;
        
        
        return head;
    }
}
