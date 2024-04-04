// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

// Date: 22 March 2024

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }  

        ListNode midNode = findMidNode(head);

        ListNode prev = null;
        ListNode curr = midNode;
        ListNode next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode right = prev;
        ListNode left = head;

        while(right != null) {
            if(left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public static ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
} 
