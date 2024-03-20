// You are given two linked lists: list1 and list2 of sizes n and m respectively.
// Remove list1's nodes from the ath node to the bth node, and put list2 in their place.

// Date: 20 March 2024

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ptrA = list1;
        ListNode ptrB = list1;
        ListNode ptr = list1;
        int count = 0;

        while(ptr.next != null) {
            int tempCount = count+1;
            if(tempCount == a) {
                ptrA = ptr;
            }
            if(count == b) {
                ptrB = ptr;
                break;
            }
            count++;
            ptr = ptr.next;

        }
        ListNode tail = list2;
        while(tail.next != null) {
            tail = tail.next;
        }

        ptrA.next = list2;
        tail.next = ptrB.next;
        ptrB.next = null;

        return list1;
    }
}