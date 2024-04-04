// You are given the head of a singly linked-list. The list can be represented as:
// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

// Date: 23 March 2024

class Solution {
    public void reorderList(ListNode head) {
        // find mid
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        //  Reverse second half
        ListNode curr = mid.next;
        mid.next = null;
        ListNode prev = null;
        ListNode next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode leftHead = head;
        ListNode rightHead = prev;
        ListNode nextLeft, nextRight;
        while(leftHead != null && rightHead != null){
            nextLeft = leftHead.next;
            leftHead.next = rightHead;
            nextRight = rightHead.next;
            rightHead.next = nextLeft;

            //Updation
            leftHead = nextLeft;
            rightHead = nextRight;
        }
    }
}