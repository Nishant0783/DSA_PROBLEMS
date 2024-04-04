// Given a square matrix mat[][] of n*n size, the task is to determine the diagonal pattern which is a linear arrangement of the elements of the matrix as depicted in the following example:

// Date: 13 March 2024

class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int i = 0, j = 0;
        int row = mat.length;
        int col = mat[0].length;
        int indx = 0;
        int[] ans = new int[row*col];
        ans[indx] = mat[i][j];
        indx++;
        
        while(i<(row-1) || j<(col-1)){
            if(j+1 < col) {
                j+=1;
                ans[indx] = mat[i][j];
                indx++;
            } else {
                i+=1;
                ans[indx] = mat[i][j];
                indx++;
            }
            
            while((i+1 < row) && (j-1 >= 0)) {
                i+=1;
                j-=1;
                ans[indx] = mat[i][j];
                indx++;
            }
            if(i+1 < row) {
                i+=1;
                ans[indx] = mat[i][j];
                indx++;
            } else {
                j+=1;
                ans[indx] = mat[i][j];
                indx++;
            }
            while((i-1 >= 0) && (j+1 <col)) {
                i-=1;
                j+=1;
                ans[indx] = mat[i][j];
                indx++;
            }
        }
        
        return ans;
    }
}