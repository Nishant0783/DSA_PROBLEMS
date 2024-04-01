// Given a string s consisting of words and spaces, return the length of the last word in the string.
// A word is a maximal substring consisting of non-space characters only.

// Date: 01 April 2024

class Solution {
    public int lengthOfLastWord(String s) {
        String str = s.trim();
        int count = 0;
        for(int i = str.length()-1; i>=0; i--){
            if(str.charAt(i) != ' '){
                count++;
            }else{
                break;
            }
        }
        return count;
        
    }
}