/*
 * @lc app=leetcode.cn id=1035 lang=java
 *
 * [1035] 不相交的线
 */

// @lc code=start
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        //一条线就是两个相同的元素，
        //多条不相交的线就是相当于多个按照顺序的相同元素，即为求最长公共子序列
        //两道题代码一模一样；
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for(int i=1; i<nums1.length+1; i++){
            for(int j=1; j<nums2.length+1; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];

    }
}
// @lc code=end

