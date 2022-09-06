/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {

    //根据代码随想录抄写
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();

    }
    
    public void push(int x) {
        stackIn.push(x);
    }
    
    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }
    
    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }
    
    public boolean empty() {
        return (stackIn.isEmpty() && stackOut.isEmpty());
    }

    private void dumpStackIn(){
        //如果stackOut为空，那么将stackIn的元素全放到stackOut中；
        if(!stackOut.isEmpty()) return;
        while(!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

