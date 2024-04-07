// Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

// The following rules define a valid string:

// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

// Date: 07 April 2024


class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftParentheses = new Stack<>();
        Stack<Integer> stars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                leftParentheses.push(i);
            else if (ch == '*')
                stars.push(i);
            else {
                if (!leftParentheses.isEmpty())
                    leftParentheses.pop();
                else if (!stars.isEmpty())
                    stars.pop();
                else
                    return false;
            }
        }

        while (!leftParentheses.isEmpty() && !stars.isEmpty()) {
            if (leftParentheses.pop() > stars.pop())
                return false;
        }

        return leftParentheses.isEmpty();
    }
}