/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack1 = new Stack<>();
        for(String s: tokens){
            if(s.equals("+")){
                int a = stack1.pop();
                int b = stack1.pop();
                stack1.push(a+b); //注意-和/的顺序；+和*的顺序无关；
            }
            else if(s.equals("-")){
                int a = stack1.pop();
                int b = stack1.pop();
                stack1.push(-a+b);
            }
            else if(s.equals("*")){
                int a = stack1.pop();
                int b = stack1.pop();
                stack1.push(a*b);
            }
            else if(s.equals("/")){
                int a = stack1.pop();
                int b = stack1.pop();
                stack1.push(b/a);
            }
            else{
                stack1.push(Integer.valueOf(s));//这个是什么用法
            }
        }

        return stack1.pop();


    }
}
// @lc code=end

