// Given a m*n grid with each cell consisting of positive, negative, or zero point. We can move across a cell only if we have positive points. Whenever we pass through a cell, points in that cell are added to our overall points, the task is to find minimum initial points to reach cell (m-1, n-1) from (0, 0) by following these certain set of rules :
// 1. From a cell (i, j) we can move to (i + 1, j) or (i, j + 1).
// 2. We cannot move from (i, j) if your overall points at (i, j) are <= 0.
// 3. We have to reach at (n-1, m-1) with minimum positive points i.e., > 0.

// Date: 09 April 2024

class Solution {
    public int minPoints(int points[][], int m, int n) {
        // Your code goes here
        int[][] dp = new int[m][n];

        dp[m-1][n-1] = Math.max(1, 1 - points[m-1][n-1]);

        for (int i = m - 1; i >= 0; i--) 
        {
            for (int j = n - 1; j >= 0; j--) 
            {
                if (i == m - 1 && j == n - 1)
                    continue;

                int minPointsRequired = Integer.MAX_VALUE;

                if (i + 1 < m)
                    minPointsRequired = Math.min(minPointsRequired, dp[i + 1][j]);

                if (j + 1 < n)
                    minPointsRequired = Math.min(minPointsRequired, dp[i][j + 1]);

                dp[i][j] = Math.max(1, minPointsRequired - points[i][j]);
            }
        } 
        return dp[0][0];
    }
}