import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        //计算雨水的面积，需要高度h = min(height[st.top(), height[i]] - height[mid]);
        //宽度w = i - st.top() - 1; 只有中间的能存雨水，两头节点都不能存，所以-1
        int lens = height.length;
        if(lens <= 2) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int sum = 0;
        for( int i=1; i<height.length; i++){
            int stackTop = stack.peek();
            //如果呈现递减，则左边无法存雨水，直接压栈
            if(height[i] < height[stackTop]){
                stack.push(i);
            }
            //如果高度相等，存入最新的右边index；
            else if(height[i] == height[stackTop]){
                stack.pop();
                stack.push(i);
                //弹出原数据，存入新index
            }
            //如果呈现递增，则可以存入雨水，且所有heightAtIdx > height[stackTop]都可以存雨水，使用while
            else{
                int heightAtIdx = height[i];
                while(!stack.isEmpty() && heightAtIdx > height[stackTop]){
                    int mid = stack.pop();
                    //这里计算过程，需要注意处理细节
                    if(!stack.isEmpty()){
                        int left = stack.peek();
                        //高度为左右节点更小点 与 mid的 高度差
                        int h = Math.min(height[left], height[i]) - height[mid];
                        //宽度w = i - st.top() - 1; 只有中间的能存雨水，两头节点都不能存，所以-1
                        int w = i - left - 1;
                        int hold = h * w;
                        //if(hold > 0) 
                        sum+= hold;
                        stackTop = stack.peek();
                    }
                }
                stack.push(i);
            }
        }

        return sum;

    }
}
// @lc code=end

