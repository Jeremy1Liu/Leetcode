/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        //看的代码随想录，解法很精彩，但感觉很难想到
        //画出dp的二维矩阵，有助于理解。
        //dp[i][j]表达下标为i-1为结尾的A和下标j-1结尾的B，最长重复数组长度为dp[i][j];
        //核心思想是dp[i][j]是由dp[i-1][j-1] 推出的,如果A[i-1] == B[j-1], 则dp[i][j] = dp[i-1]dp[j-1] + 1;
        int res = 0;
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        //没有赋值，则所有初始值为0；符合这道题的解法

        //dp[i][j]是记录的nums1[i-1], nums2[j-1]的最大重复子数组，因此i,j需要遍历到length+1;
        for(int i=1; i<nums1.length+1; i++){
            for(int j=1; j<nums2.length+1; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res, dp[i][j]);
                }

            }
        }

        return res;

    }
}
// @lc code=end

