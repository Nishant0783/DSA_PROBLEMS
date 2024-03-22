// Consider Red lines of slope -1 passing between nodes (in following diagram). The diagonal sum in a binary tree is the sum of all node datas lying between these lines. Given a Binary Tree of size n, print all diagonal sums.

// For the following input tree, output should be 9, 19, 42.
// 9 is sum of 1, 3 and 5.
// 19 is sum of 2, 6, 4 and 7.
// 42 is sum of 9, 10, 11 and 12.

// Date: 22 March 2024


class Tree {
    public static ArrayList <Integer> diagonalSum(Node root) 
    {
        // code here.
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        HashMap<Integer, Integer> diagonalSums = new HashMap<>();
        diagonalSumHelper(root, diagonalSums, 0); // Start traversal from root

        // Convert HashMap values to ArrayList
        for (int sum : diagonalSums.values()) {
            result.add(sum);
        }

        return result;
    }

    private static void diagonalSumHelper(Node node, HashMap<Integer, Integer> diagonalSums, int diagonalLevel) {
        // Base case
        if (node == null)
            return;

       
        diagonalSums.put(diagonalLevel, diagonalSums.getOrDefault(diagonalLevel, 0) + node.data);

        diagonalSumHelper(node.left, diagonalSums, diagonalLevel + 1);


        diagonalSumHelper(node.right, diagonalSums, diagonalLevel);
    
    }
}