// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i]. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer. You must write an algorithm that runs in O(n) time and without using the division operation.

// Date: 15 March 2024

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;

        if (noOfZeroes(nums) > 1) { 
            for (int i = 0; i < nums.length; i++) {
                nums[i] = 0;
            }
        } else if (noOfZeroes(nums) == 1) {
            for (int i : nums) {
                if (i != 0) {
                    prod = prod * i; 
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)
                    nums[i] = prod;

                else
                    nums[i] = 0;
            }
        } else {
            for (int i : nums) {
                prod = prod * i;
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = prod / nums[i];
            }
        }

        return nums;
    }

    public int noOfZeroes(int[] arr) {
        int count = 0;

        for (int i : arr) {
            if (i == 0)
                count++;
        }

        return count;
    }
}