import java.util.Stack;

/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {

        //所谓循环搜索下一个更大的数，就是遍历到尾之后，再次遍历到当前位置
        //可以直接遍历2次
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();

        //这里直接遍历数组两次；
        //数组元素存入stack之后就没有了index，所以需要存储index，而不是元素值
        //当找到了更大值，则记录res[stack.peek()] = nums[i % nums.length];
        for(int i=0; i< 2*nums.length; i++){
            while(!stack.isEmpty() && nums[i%nums.length] > nums[stack.peek()]){
                res[stack.peek()] = nums[i%nums.length];
                stack.pop();
            }
            stack.push(i%nums.length);
        }
        return res;
    }
}
// @lc code=end

