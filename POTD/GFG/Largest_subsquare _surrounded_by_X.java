// Given a square matrix a of size n x n, where each cell can be either 'X' or 'O', you need to find the size of the largest square subgrid that is completely surrounded by 'X'. More formally you need to find the largest square within the grid where all its border cells are 'X'.

// Date: 14 March 2024

class Solution {
    int largestSubsquare(int n, char a[][]) {
        // code here
        int[][] col = new int[n][n];
        int[][] row = new int[n][n];

        for (int i = 0; i < n; ++i) {
            int sum = 0;
            for (int j = n - 1; j >= 0; --j) {
                sum = (a[i][j] == 'O') ? 0 : sum + 1;
                col[i][j] = sum;
            }
        }

        for (int j = 0; j < n; ++j) {
            int sum = 0;
            for (int i = n - 1; i >= 0; --i) {
                sum = (a[i][j] == 'O') ? 0 : sum + 1;
                row[i][j] = sum;
            }
        }

        int out = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int sq = Math.min(col[i][j], row[i][j]);
                while (sq > out) {
                    if ((col[i + sq - 1][j]) >= sq && (row[i][j + sq - 1]) >= sq)
                        out = sq;

                    --sq;
                }
            }
        }
        return out;
    }
};