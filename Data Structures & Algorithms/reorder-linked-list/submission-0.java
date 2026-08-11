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
    public void reorderList(ListNode head) {
          ListNode slow=head;
          ListNode fast=head;
          while (fast != null && fast.next != null) {
               slow=slow.next;
               fast=fast.next.next;
          }
          ListNode second=slow.next;
          slow.next=null;

          ListNode prev = null, curr = second;

          while (curr != null) {
               ListNode next = curr.next;
               curr.next = prev;
               prev = curr;
               curr = next;
          }

          ListNode first = head;
          ListNode reversed = prev;

          while (reversed != null) {
               ListNode next1 = first.next;
               ListNode next2 = reversed.next;

               first.next = reversed;
               reversed.next = next1;

               first = next1;
               reversed = next2;
          }
    }
}
