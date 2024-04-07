// Given two arrays a and b of positive integers of size n and m where n >= m, the task is to maximize the dot product by inserting zeros in the second array but you cannot disturb the order of elements.
// Dot product of array a and b of size n is a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1].

// Date: 07 April 2024

class Solution
{
	public int maxDotProduct(int n, int m, int a[], int b[]) 
	{ 
		// Your code goes here
		 int[][] dp = new int[m + 1][n + 1];
        // Initializing dp array with zeros
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 0;
            }
        }
        
        // Filling dp array
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + a[j - 1] * b[i - 1], dp[i][j - 1]);
            }
        }
        
        return dp[m][n];
	} 
}
