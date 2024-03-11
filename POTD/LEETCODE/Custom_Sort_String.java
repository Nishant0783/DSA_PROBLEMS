// You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously. Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string. Return any permutation of s that satisfies this property.

// Date - 11 March 2024

class Solution {
    public String customSortString(String order, String s) {
        int map[] = new int[26];
        for(int i = 0; i<s.length(); i++) {
           map[s.charAt(i) - 'a']++; 
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<order.length(); i++){
            char ch = order.charAt(i);
            int value = map[ch - 'a'];
            sb.append(String.valueOf(ch).repeat(value));
            map[ch-'a'] = -1;
        }
        
        for(int i = 0; i<map.length; i++) {
            if(map[i] > 0){
                int value = map[i];
                char ch = (char)('a' + i);
                sb.append(String.valueOf(ch).repeat(value));
            }
        }
        return sb.toString();
    }
}