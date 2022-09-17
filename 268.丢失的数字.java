/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 丢失的数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        //位运算中，经典的XOR使用。
        //自己XOR自己，得到0，则只出现一次的数据会留下来到最后。
        int res=0;
        for( int i=0; i< nums.length; i++){
            res = res ^ nums[i] ^ i;
        }
        res ^= nums.length;

        return res;

    }
}
// @lc code=end

