// Given a binary tree with n nodes, find the number of pairs violating the BST property.
// BST has the following properties:-
// Every node is greater than its left child and less than its right child.
// Every node is greater than the maximum value of in its left subtree and less than the minimum value in its right subtree.
// The maximum in the left sub-tree must be less than the minimum in the right subtree.

// Date: 01 April 2024


class Solution {

    long merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int k = 0, i = low, j = mid + 1;
        long inv = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                inv += mid - i + 1;
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (int x = low; x <= high; x++) {
            arr[x] = temp[x - low];
        }

        return inv;
    }

    long mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0;
        long inv = 0;

        int mid = (low + high) / 2;

        inv += mergeSort(arr, low, mid);
        inv += mergeSort(arr, mid + 1, high);
        inv += merge(arr, low, mid, high);

        return inv;
    }

    long inversionCount(int[] arr, int N) {
        return mergeSort(arr, 0, N - 1);
    }

    void inorder(Node root, List<Integer> arr) {
        if (root != null) {
            inorder(root.left, arr);
            arr.add(root.data);
            inorder(root.right, arr);
        }
    }

    /* You are required to complete below function */
    int pairsViolatingBST(int n, Node root) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);

        // Convert List<Integer> to int[]
        int[] arrInt = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            arrInt[i] = arr.get(i);
        }

        return (int) inversionCount(arrInt, n);
    }
}

