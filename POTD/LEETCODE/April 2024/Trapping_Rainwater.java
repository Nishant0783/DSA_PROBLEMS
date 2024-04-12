// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

// Date: 12 April 2024

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        // Creating leftMax array
        int leftMax[] = new int[n];
        //Updating values in leftMax array
        leftMax[0] = height[0];
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        
        // Creating rightMax array
        int rightMax[] = new int[n];
        // Updating values in rightMax array
        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        
        int trappedWater = 0;
        for(int i=0; i<n; i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }
}