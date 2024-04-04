// You are given an integer array nums and an integer k.
// The frequency of an element x is the number of times it occurs in an array.
// An array is called good if the frequency of each element in this array is less than or equal to k.
// Return the length of the longest good subarray of nums.
// A subarray is a contiguous non-empty sequence of elements within an array.


// Date: 28 March 2024

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int maxLength = 0;
        for (int start = 0, end = 0; end < nums.length; ++end) {
            count.put(nums[end], count.getOrDefault(nums[end], 0) + 1);
            while (count.get(nums[end]) > k) {
                count.put(nums[start], count.get(nums[start]) - 1);
                if (count.get(nums[start]) == 0) {
                    count.remove(nums[start]);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}