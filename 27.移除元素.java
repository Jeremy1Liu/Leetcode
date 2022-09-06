/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        //双指针的简单应用；
        int len = nums.length;
        int p1, p2, n=0;
        for(p1=0, p2=0; p2<len; p2++){
            if(nums[p2] != val) nums[p1++] = nums[p2];


        }
        return p1;
    }
}
// @lc code=end

