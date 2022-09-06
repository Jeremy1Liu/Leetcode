/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {

        //用双指针，往两边向中间步进，写入新数组；自己想出来的
        int[] res = new int[nums.length];
        int i=0, j = nums.length-1, len = nums.length-1;
        for(; i<=j ; ){
            res[len--] = square(nums[i]) > square(nums[j]) ? 
            square(nums[i++]) : square(nums[j--]);
        }

        return res;
    }

    private int square(int x){
        return x*x;
    }
}
// @lc code=end

