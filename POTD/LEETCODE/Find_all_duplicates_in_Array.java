// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

// You must write an algorithm that runs in O(n) time and uses only constant extra space.

// Date: 25 March 2024

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
          List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; 
            if (nums[index] < 0) {
                duplicates.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }

        return duplicates;
    }
}