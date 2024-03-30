// You are given an integer n, return the fibonacci series till the nth(0-based indexing) term. Since the terms can become very large return the terms modulo 109+7.

// Date: 23 March 202

class Solution {

    int[] Series(int n) {
        // code here
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        if (n > 0)
            dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp;
    }
}