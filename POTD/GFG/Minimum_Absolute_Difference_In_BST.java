// Given a binary search tree having n (n>1) nodes, the task is to find the minimum absolute difference between any two nodes.

// Date: 02 March 2024

class Solution
{
    
    static int ans = Integer.MAX_VALUE,previous=-1;
    static void help(Node root){
        if(root==null)return;
        help(root.left);
        if(previous!=-1)ans=Math.min(ans,Math.abs(root.data-previous));
        previous=root.data;
        help(root.right);
    }
    int absolute_diff(Node root)
    {
        //Your code here
        ans = Integer.MAX_VALUE;
        previous=-1;
        help(root);
        return ans;
    }

}



