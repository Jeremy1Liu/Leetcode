/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int sum = 0, max = 0, flag = 0;
        int p1=0, p2=0;
        while(p2 < k){
            sum += nums[p2++];
        }
        max = sum;
        res[0] = max;
        while(p2 < nums.length){
            sum = sum + nums[p2++] - nums[p1++];
            if(sum > max) max = sum;
            res[p1] = max;
        }

        return res;
    }
}
// @lc code=end

