// Given the root of a Binary Search Tree. The task is to find the minimum valued element in this given BST.

// Date: 30 March 2024


class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        // code here
         if (root == null) {
            return -1;
        }
        
      
        while (root.left != null) {
            root = root.left;
        }
        

        return root.data;
    }
}
