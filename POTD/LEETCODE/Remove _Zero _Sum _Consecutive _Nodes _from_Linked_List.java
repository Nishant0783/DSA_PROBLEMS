// Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.After doing so, return the head of the final linked list.  You may return any such answer.

// Date - 12 March 2024

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        int prefix = 0;
        Map<Integer, ListNode> prefixToNode = new HashMap<>();
        prefixToNode.put(0, dummy);

        for (; head != null; head = head.next) {
            prefix += head.val;
            prefixToNode.put(prefix, head);
        }

        prefix = 0;

        for (head = dummy; head != null; head = head.next) {
            prefix += head.val;
            head.next = prefixToNode.get(prefix).next;
        }

        return dummy.next;
    }
}