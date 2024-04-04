//Given an integer s represented as a string, the task is to get the sum of all possible sub-strings of this string.
// As the answer will be large, return answer modulo 109+7. 
// Note: The number may have leading zeros.

// Date: 04 April 2024

class Solution
{
    //Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s)
    {
        //Your code here
        int mod = 1000000007;

        int n = s.length();
        long result = 0;
        long multiplier = 1; 

        for (int i = n - 1; i >= 0; i--) 
        {
            int digit = s.charAt(i) - '0'; 
            result = (result + (digit * multiplier * (i + 1)) % mod) % mod;
            multiplier = (multiplier * 10 + 1) % mod; 
        }

        return result;
    }
}