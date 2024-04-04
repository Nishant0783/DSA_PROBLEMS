// Given an integer array nums and an integer k, return the number of good subarrays of nums.
// A good array is an array where the number of different integers in that array is exactly k.
// For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
// A subarray is a contiguous part of an array.

// Date: 30 March 2024

class Solution {
       public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    
    private int atMostKDistinct(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;
        
        while (right < n) {
            frequencyMap.put(nums[right], frequencyMap.getOrDefault(nums[right], 0) + 1);
            while (frequencyMap.size() > k) {
                frequencyMap.put(nums[left], frequencyMap.get(nums[left]) - 1);
                if (frequencyMap.get(nums[left]) == 0) {
                    frequencyMap.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
            right++;
        }
        
        return count;
    }
}