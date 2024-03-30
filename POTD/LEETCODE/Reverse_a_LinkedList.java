// Reverese the given linked list and return the head of the  reversed list.

// Date: 21 March 2024

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr;
        ListNode tail;
        curr = tail = head;
        ListNode next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

        return head;
    }
}