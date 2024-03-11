// Given two sorted matrices mat1 and mat2 of size n x n of elements. Each matrix contains numbers arranged in strictly ascending order, with each row sorted from left to right, and the last element of a row being smaller than the first element of the next row. You're given a target value, x, your task is to find and count all pairs {a, b} such that a is from mat1 and b is from mat2 where sum of a and b is equal to x.

// Date - 11 March 2024

class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        int count = 0; 
        int size = n*n;
        
        for(int p = 0; p<n; p++) {
            for(int q = 0; q<n; q++){
                mat1[p][q] = (x - mat1[p][q]);
            }
        }
        
        int r1 = 0, c1 = 0;
        int r2 = n-1, c2 = n-1;
        
        while((r1<n) && (r2>=0)){
            if(mat1[r1][c1] == mat2[r2][c2]){
                count++;
                c1++;
                c2--;
            }else if(mat1[r1][c1] > mat2[r2][c2]){
                c1++;
            }else {
                c2--;
            }
            
            if(c1 == n) {
                c1 = 0;
                r1++;
            }
            if(c2 == -1){
                c2 = n-1;
                r2--;
            }
        }
        
        return count;
    }
}