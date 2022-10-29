/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //这种dp的题，核心是要理解dp[i][j]代表什么
        //长度为[0, i-1]的字符串text1 和长度为[0, j-1]的字符串text2的最长公共子序列长度为dp[i][j];
        //其次是理解dp的递推公式:
        //如果text1[i] == text2[j] , 则dp[i][j] = dp[i-1][j-1] +1;
        //如果不等，dp[i][j] = max(dp[i-1][j], dp[i][j-1]);

        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=1; i<text1.length()+1; i++){
            for(int j=1; j<text2.length()+1; j++){
                //这个if代表左上脚某一段是重复的；
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                //这个else表示目前不重复，但是前面某些元素可能重复，因此向上和左方找最大值；
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()] [text2.length()];


    }
}
// @lc code=end

