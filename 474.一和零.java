/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String str : strs){
            int zeroNum = 0, oneNum = 0;
            for(char c : str.toCharArray()){
                //统计单个str的0/1元素个数，用于后面填放dp数组；
                if(c == '0') zeroNum++;
                else oneNum++;
            }

            for(int i = m; i>= zeroNum; i--){
                for(int j = n; j>= oneNum; j--){
                    //如下这个dp经过多次遍历，相当于把二位数组刷新了strs.length()次
                    //单次更新的逻辑是从后往前更新，默认值为0，即可以存放0个str元素；
                    //dp[i-zeroNum][j-oneNum]即为有额外zeroNum个0和oneNum个1的数组的最大存放值，加上1就是可以加上这个str元素。
                    //Math.max() 是为了遍历最外一层for循环str的遍历；
                    //我认为总的时间复杂度是m*n*strs.length();
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeroNum][j-oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

