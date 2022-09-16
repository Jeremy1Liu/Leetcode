/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        // //方法1：可以通过
        // for(int i=0; i<32; i++){
        //     if(x%2 != y%2) count++;
        //     x /= 2;
        //     y /= 2;
        // }
        // return count;

        // //方法2：使用XOR的运算方式；
        // int s = x ^ y;
        // while(s != 0){
        //     count += s&1;
        //     //s进行右移操作
        //     s >>= 1;
        // }
        // return count;

        //方法3：效率更高，只统计1的个数，跳过0的个数
        int s = x ^ y;
        while(s != 0){
            s = s & (s-1);
            count++;
        }
        return count;

    }
}
// @lc code=end

