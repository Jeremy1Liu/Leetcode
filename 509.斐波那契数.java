/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int n) {

        int f0 = 0;
        int f1 = 1;
        int res = n==0 ? 0 : 1;
        for(int i = 2; i<=n; i++){
            res = f0 + f1;
            f0 = f1;
            f1 = res;
        }

        return res;

    }
}
// @lc code=end

