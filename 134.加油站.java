/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        //学习的代码随想录的贪心算法
        int curSum=0, totalSum=0, start=0;
        for(int i=0; i<gas.length; i++){
            totalSum += gas[i] - cost[i];
            curSum += gas[i] - cost[i];
            if(curSum < 0){
                //如果当前的curSum为负，说明前半部分油不够；则后半部分一定够。前提是totalSum大于0；
                //那么每次记录下curSum的位置，start从i+1开始。
                //类似于买股票，负的部分不要。
                start = i+1;
                curSum = 0;
            }
        }
        //需要统计总的gas是否覆盖cost，可以理解。
        if(totalSum < 0) return -1;
        //如果totalSum》=0， 则一定存在这个位置。
        else return start;
    }
}
// @lc code=end

