// Given a root of a binary tree with n nodes, find its level order traversal. Level order traversal of a tree is breadth-first traversal for the tree.

// Date: 18 March 2024

class Solution
{
   
    static ArrayList <Integer> levelOrder(Node root) 
    {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); 
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll(); 
                result.add(currentNode.data); 

             
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
        }
        return result;
    }
}