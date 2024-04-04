// Given the root of a binary search tree and a number n, find the greatest number in the binary search tree that is less than or equal to n. 

// Date: 31 March 2024

class Solution {
    public static int findMaxForN(Node root, int n) {
        // Add your code here.
        if(root == null)
            return -1;
            
        int maxValue = -1;
        int ans = helper(root, maxValue, n);
        
        return ans;
    }
    
    private static int helper(Node node, int maxValue, int n) {
        if(node == null) {
            return maxValue;
        }
        
        if(node.key > maxValue && node.key <= n) {
            maxValue = node.key;
        }
        
        int leftMax = helper(node.left, maxValue, n);
        int rightMax = helper(node.right, maxValue, n);
        
        return Math.max(leftMax, rightMax);
    }
}