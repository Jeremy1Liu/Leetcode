/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack1 = new Stack<>();
        char ch;

        for(int i=0; i<s.length(); i++){
            ch = s.charAt(i);
            if(ch == '(') stack1.push(')');
            else if(ch == '[') stack1.push(']');
            else if(ch == '{') stack1.push('}');
            else if(stack1.isEmpty() || stack1.peek() != ch) 
                return false;
            else stack1.pop();
        }

        return stack1.isEmpty();
    }
}
// @lc code=end

