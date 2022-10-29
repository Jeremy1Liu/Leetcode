import java.util.Deque;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //单调栈相当于用空间换时间。栈中存储的元素从栈底到栈顶是递减的，
        //因此当tem[i]>tem[stack.peek()]时，需要使用while，多次遍历，直到不大于；
        //当tem[i]小于等于时，则说明此节点并非是前面栈中节点的更大值，所以直接存入栈中；
        int lens = temperatures.length;
        int[] res = new int[lens];

        //栈中只存储index,不存储具体节点的数值；
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for(int i=1; i<lens; i++){
            if(temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;

    }
}
// @lc code=end

