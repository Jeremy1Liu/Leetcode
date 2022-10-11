/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        // int i;
        // for(i=1; i < n; i++){
        //     n -= i;

        // }
        // return n == i ? i : i-1;
        int i=1;
        int sum = 1;
        for( i=1; sum<=n; i++){
            sum = i*(i+1)/2;
        }
        return  i-2 ;

    }
}
// @lc code=end

