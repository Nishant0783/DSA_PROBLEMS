// Given a positive integer n. Your task is to generate a string list of all n-bit binary numbers where, for any prefix of the number, there are more or an equal number of 1's than 0's. The numbers should be sorted in decreasing order of magnitude.

// Date: 25 March 2024

class Solution {
    static void help(ArrayList<String> ans,int zero,int one, StringBuilder temp, int N){
        if(temp.length()==N){
            ans.add(temp.toString());
            return;
        }
        if(one>zero){
            temp.append('0');
            help(ans,zero+1,one,temp,N);
            temp.deleteCharAt(temp.length()-1);
        }
        temp.append('1');
        help(ans,zero,one+1,temp,N);
        temp.deleteCharAt(temp.length()-1);
    }
    ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        temp.append('1');
	    help(ans,0,1,temp,N);
	    Collections.sort(ans);
	    Collections.reverse(ans);
	    return ans;
    }

}