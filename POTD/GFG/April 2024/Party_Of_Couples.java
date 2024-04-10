// You are given an integer array arr[] of size n, representing n number of people in a party, each person is denoted by an integer. Couples are represented by the same number ie: two people have the same integer value, it means they are a couple. Find out the only single person in the party of couples.
// NOTE: It is guarantee that there exist only one single person in the party. 

// Date: 10 April 2024

class Solution{
    static int findSingle(int n, int arr[]){
        // code here
        int xor = 0;

        for(int num : arr) {
            xor = xor ^ num;
        }

        return xor;
    }
}
  