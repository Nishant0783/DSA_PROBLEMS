// Given an array nums of n positive integers. Find the minimum number of operations required to modify the array such that array elements are in strictly increasing order (nums[i] < nums[i+1]).
// Changing a number to greater or lesser than original number is counted as one operation.
// Note: Array elements can become negative after applying operation.

// Date: 05 April 2024

class Solution
{
    public int min_operations(int []nums)
    {
        // Code here
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int maxi = 1;

        for(int i = 1;i < n;i++)
        {
            for(int j = 0;j < i;j++)
            {
                if(nums[i]-nums[j]>=i-j)
                {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    maxi = Math.max(maxi,dp[i]);
                }
            }
        } 

        return n-maxi;
    }
}
