// You are given a Linked list of size n. The list is in alternating ascending and descending orders. Sort the given linked list in non-decreasing order.

// Date: 15 March 2024


class Solution {
    
   public Node sort(Node head){
        //your code here, return the head of the sorted list
        if(head == null || head.next == null || head.next.next == null)
            return head;
            
        Node temp = head;
        head = head.next;
        Node ptr1 = head;
        Node ptr2 = temp;
        
        while(ptr1 != null && ptr1.next != null) {
            ptr2.next = ptr1.next;
            ptr1.next = ptr1.next.next;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        Node prev = null;
        Node curr = head;
        Node next;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ptr2.next = prev;
        
        return temp;

   }