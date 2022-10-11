/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] 最后一块石头的重量 II
 */

// @lc code=start
class Solution {
    public int lastStoneWeightII(int[] stones) {
        //这道题类比416分割子集问题，这是求背包最多能装多少
        //背包容量为sum/2，看这些stone最大的组合是多少。
        //外层的循环是遍历这些stone，没有顺序之分
        //内层的循环是倒序遍历dp[j],终止点为j>=stone[i],
        //说明目前容量根本装不下stone[i]单个元素，没有再向前遍历的必要。
        if(stones.length == 0) return 0;
        int sum=0;
        for(int stone : stones) sum += stone;

        int[] dp = new int[sum/2 + 1];

        for(int i=0; i<stones.length; i++){
            for(int j=sum/2; j>=stones[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-stones[i]]+stones[i]);
            }
        }

        return sum - 2 * dp[dp.length-1];

    }
}
// @lc code=end

