/*
 * @lc app=leetcode.cn id=1299 lang=java
 *
 * [1299] 将每个元素替换为右侧最大元素
 */

// @lc code=start
class Solution {
    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        res[arr.length - 1] = -1;
        int curMax = -1;
        for(int i=arr.length-2; i>=0; i--){
            curMax = Math.max(curMax, arr[i+1]);
            res[i] = curMax;
        }

        return res;

    }
}
// @lc code=end

