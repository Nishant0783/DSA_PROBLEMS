// You are given an integer array nums and two integers minK and maxK.
// A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
// The minimum value in the subarray is equal to minK.
// The maximum value in the subarray is equal to maxK.
// Return the number of fixed-bound subarrays.
// A subarray is a contiguous part of an array.

// Date: 31 March 2024

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
          int badB = -1;
            int minB = -1;
            int maxB = -1;
            long count = 0;

            for(int i=0; i<nums.length; i++) {
                if(nums[i] < minK || nums[i] > maxK) {
                    badB = i;
                }

                if(nums[i] == minK) {
                    minB = i;
                }

                if(nums[i] == maxK) {
                    maxB = i;
                }

                count += Math.max(0, (Math.min(minB, maxB) - badB));
            }

            return count;
    }
}

