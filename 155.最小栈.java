import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {
    Stack<Node> stack = new Stack<>();

    public MinStack() {

    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Node(val,val));
        }
        else {
            stack.push(new Node(val, Math.min(val, getMin())));
        }

    }
    
    public void pop() {
        stack.pop();

    }
    
    public int top() {
        return stack.peek().val;

    }
    
    public int getMin() {
        return stack.peek().min;

    }

    private static class Node{
        int val;
        int min;

        public Node(int val2, int val3) {
            this.val = val2;
            this.min = val3;
        }
        

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

