// https://leetcode.com/problems/evaluate-reverse-polish-notation
// Evaluate reverse Polish notation

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String t: tokens) {
            try {
                int num = Integer.parseInt(t);
                stack.push(num);
            } catch(Exception e) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(t.equals("*")) {
                    stack.push(num1*num2);
                } else if(t.equals("/")) {
                    stack.push(num2/num1);
                } else if(t.equals("+")) {
                    stack.push(num1+num2);
                } else {
                    stack.push(num2 - num1);
                }
            }
        }
        return stack.pop();
    }
}
