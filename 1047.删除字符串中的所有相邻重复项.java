/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack1 = new Stack<>();
        char ch;
        for(int i=0; i<s.length(); i++){
            ch = s.charAt(i);
            if(stack1.isEmpty() || stack1.peek() != ch) stack1.push(ch);
            else stack1.pop();

        }
        Stack<Character> stack2 = new Stack<>();

        // while(!stack1.isEmpty()){
        //     stack2.push(stack1.peek());
        //     stack1.pop();
        // }

        //Stack是逆序一次，str = stack1.pop() + str;是逆序第二次，实现正序；
        String str = "";
        while(!stack1.isEmpty()){
            //可以直接把stack加到str的前面，则实现了逆序；
            str = stack1.pop() + str;
        }

        return str;

    }
}
// @lc code=end

