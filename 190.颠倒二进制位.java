/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        //int有32位，因此循环32次；
        for(int i=0; i<32; i++){
            //每次将res的数据左移，并且加上n最右的一位；
            res<<=1;
            res += n&1;

            //每次将n左移；
            n>>=1;
        }
        return res;
        
    }
}
// @lc code=end

