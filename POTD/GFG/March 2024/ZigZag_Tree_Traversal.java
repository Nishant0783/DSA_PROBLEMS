// Given a binary tree with n nodes. Find the zig-zag level order traversal of the binary tree.

// Date: 21 March 2024

class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	          ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true; // flag to toggle direction

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node current;
                if (leftToRight) {
                    current = queue.pollFirst(); // remove first for left to right
                    if (current.left != null)
                        queue.offerLast(current.left);
                    if (current.right != null)
                        queue.offerLast(current.right);
                } else {
                    current = queue.pollLast(); // remove last for right to left
                    if (current.right != null)
                        queue.offerFirst(current.right);
                    if (current.left != null)
                        queue.offerFirst(current.left);
                }
                levelNodes.add(current.data);
            }

            // Toggle the direction for the next level
            leftToRight = !leftToRight;

            // Add the nodes of the current level to the result list
            result.addAll(levelNodes);
        }

        return result;
	}
}