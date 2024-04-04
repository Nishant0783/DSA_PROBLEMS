// Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

// Date: 16 March 2024

public class ContiguousArray {
    class Solution {
        public int findMaxLength(int[] nums) {
            int maxLength = 0;
            int sum = 0;
            Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
            hashMap.put(0, hashMap.getOrDefault(0, -1));

            for(int i=0; i<nums.length; i++) {
                if(nums[i] == 1)
                    sum++;
                else
                    sum--;
                if(!hashMap.containsKey(sum)) {
                    hashMap.put(sum, hashMap.getOrDefault(sum, i));
                }
                else {
                    if(maxLength < i - hashMap.get(sum))
                        maxLength = i - hashMap.get(sum);
                }
            }

            return maxLength;
        }
    }
}