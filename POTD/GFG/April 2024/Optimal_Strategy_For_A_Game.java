// You are given an array arr of size n. The elements of the array represent n coin of values v1, v2, ....vn. You play against an opponent in an alternating way. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin.
// You need to determine the maximum possible amount of money you can win if you go first.
// Note: Both the players are playing optimally

// Date: 08 April 2024


class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int n, int arr[])
    {
        // Your code here
        long memo[][] = new long[n+1][n+1];
        for(long x[] : memo){
            Arrays.fill(x, -2);
        }
        return fun(0,n-1, arr, memo);
    }
    static long fun(int i, int j, int arr[], long memo[][]){
        if(i>j) return 0;

        if(i==j)
        return arr[i]; // return arr[j];

        if(memo[i][j]!=-2) return memo[i][j];
        //2 calls
        //1st call - I will pick the ith ele
        long x = arr[i] + Math.min(fun(i+2, j, arr, memo) , fun(i+1, j-1, arr, memo));

        // 2nd call - I will pick the jth side
        long y = arr[j] + Math.min(fun(i, j-2, arr, memo) , fun(i+1, j-1, arr, memo));

        return memo[i][j] = Math.max(x,y);

    }
}
