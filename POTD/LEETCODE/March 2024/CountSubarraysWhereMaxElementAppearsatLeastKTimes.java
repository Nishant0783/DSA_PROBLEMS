// You are given an integer array nums and a positive integer k.

// Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

// A subarray is a contiguous sequence of elements within an array.

// Date: 29 March 2024

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int count = 0;

        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] == maxNum)
                count++;

            while (count == k) {
                if (nums[left++] == maxNum)
                    count--;
            }

            ans += left;
        }

        return ans;
    }
}

 