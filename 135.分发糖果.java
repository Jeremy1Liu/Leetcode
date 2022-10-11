/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        //看的代码随想录的方法
        int res[] = new int[ratings.length];
        res[0] = 1;
        //此循环从左向右遍历，如果右边更大，就需要加1；
        //如果相等或小于，则减一，但是要保证最小为1；
        for(int i=1; i<ratings.length; i++){
            if(ratings[i] > ratings[i-1]) res[i] = res[i-1] + 1;
            else{
                //不用控制每次递减1，可以直接减到1；
                res[i] = 1;
            }
        }

        //从后向前遍历，如果左边更大，则左边加一;
        //同时需要控制res[i] 的值取两遍遍历中的最大值。
        for(int i=ratings.length-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]) res[i] = Math.max(res[i], res[i+1] + 1);
        }


        int sum = 0;
        for(int i : res){
            sum += i;
        }
        return sum;

    }
}
// @lc code=end

