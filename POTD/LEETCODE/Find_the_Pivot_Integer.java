// Given a positive integer n, find the pivot integer x such that:
// The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
// Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.

// Date: 13 March 2024


class Solution {
    public int pivotInteger(int n) {
        int mid = (1+n)/2;
        int s1 = (mid*(mid+1) / 2);
        int s2 = ((n*(n+1)/2) + mid - s1);
        while(s1<=s2){
            if(s1==s2){
                return mid;
            }
            mid = mid+1;
            s1 = s1 + mid;
            s2 = s2 - (mid-1);
        }

        return -1;
    }
}