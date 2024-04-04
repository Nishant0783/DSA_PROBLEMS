// Given two linked list head1 and head2 with distinct elements, determine the count of all distinct pairs from both lists whose sum is equal to the given value x.
// Note: A valid pair would be in the form (x, y) where x is from first linked list and y is from second linked list.

// Date: 17 March 2024

class Solution {

    public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
        int count = 0;

        Set<Integer> set = new HashSet<Integer>();
        for(int value : head1) {
            set.add(value);
        }


        for(int value : head2) {
            if(set.contains(x - value)) {
                count++;
            }
        }

        return count;                 
    }
}
