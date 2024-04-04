//You are given a stack st of n integers and an element x. You have to insert x at the bottom of the given stack. 

// Note: Everywhere in this problem, the bottommost element of the stack is shown first while priniting the stack.

// Date: 24 March 2024

class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        Stack<Integer> s = new Stack<>();
        while(!st.isEmpty()) {
            s.push(st.pop());
        }
        
        st.push(x);
        while(!s.isEmpty()) {
            st.push(s.pop());
        }
        
        return st;
    }
}