// Given a BST with n (n>=2) nodes, find the kth common ancestor of nodes x and y in the given tree. Return -1 if kth ancestor does not exist.

// Nodes x and y will always be present in the input of a BST, and x != y.

// Date: 03 April 2024

class Solution {
    public int kthCommonAncestor(Node root, int k, int x, int y) {
        // code here
        int total = 1;
        Node temp=root;
        while(root!=null){
            if(root.data>x && root.data>y){
                root=root.left;
                total++;
            }
            else if(root.data<x && root.data<y){
                root=root.right;
                total++;
            }
            else break;
        }
        int c=1;
        total-=k;
        total++;
        root=temp;
        while(root!=null){
            if(c==total)return root.data;
            if(root.data>x && root.data>y){
                root=root.left;
                c++;
            }
            else if(root.data<x && root.data<y){
                root=root.right;
                c++;
            }
            else break;
        }
        return -1;
    }

}
