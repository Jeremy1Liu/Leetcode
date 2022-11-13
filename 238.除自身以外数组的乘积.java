/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //完全看答案的做法，
        //乘积= 当前数左边的乘积 * 当前数右边的乘积。
        //首次遍历的时候直接在res数组中存储左边的乘积
        //回过头遍历时，用k存储右边的乘积，每次更新k；

        int[] res = new int[nums.length];
        int k = 1;
        for(int i=0; i<res.length; i++){
            res[i] = k;
            k = k* nums[i];//此时数组存储的时除去当前元素左边所有元素的乘积

        }
        k=1;
        for(int i=res.length-1; i>=0; i--){
            res[i] *= k;//k为该数右边的乘积；
            k*=nums[i];//此时数组等于左边的 * 右边的；
        }

        return res;
    }
}
// @lc code=end

