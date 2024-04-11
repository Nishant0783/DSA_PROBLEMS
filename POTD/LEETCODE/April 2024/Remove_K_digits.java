// Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

// Date: 11 April 2024

class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();


        for (char digit : num.toCharArray()) {

            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {

                stack.pop();
                k--;
            }
        
            stack.push(digit);
        }


        while (k > 0) {
            stack.pop();
            k--;
        }

   
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }
}