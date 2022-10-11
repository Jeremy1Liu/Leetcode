/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // int res[] = new int[n+1];
        // res[0] = 1;
        // res[1] = 1;
        // for(int i=2; i<n+1; i++){
        //     res[i] = res[i-1] + res[i-2];
        // }
        // return res[n];

        //再爬一次楼梯，采用dp的方法；
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<n+1; i++){
            for(int j=1; j<=2; j++){
                dp[i] += dp[i-j] ;
            }
            
        }
        return dp[n];

    }
}
// @lc code=end

