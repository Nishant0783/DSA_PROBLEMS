// Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

// Date: 27 March 2024

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;

        int count = 0;
        int product = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += right - left + 1; // Add the number of subarrays ending at 'right' index
        }

        return count;
    }
}