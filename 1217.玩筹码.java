/*
 * @lc app=leetcode.cn id=1217 lang=java
 *
 * [1217] 玩筹码
 */

// @lc code=start
class Solution {
    public int minCostToMoveChips(int[] position) {
        //所有奇数位置的筹码，移动无成本
        //所有偶数位置的筹码，移动无成本
        //奇偶移动，成本为1；
        //所以就统计奇数位置，偶数位置的筹码各是多少个
        int odd=0, even=0;
        for(int posi : position) {
            if((posi & 1) != 0){
                odd++;
            }
            else{
                even++;
            }
        }
        return Math.min(odd, even);

    }
}
// @lc code=end

