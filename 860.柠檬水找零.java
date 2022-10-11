/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        //这道题只有3种货币，所以找零的情况也只有少数几种，具体分析即可。
        int num5 = 0, num10 = 0;

        for(int i : bills){
            if(i == 5) num5++;
            else if(i == 10){
                num10++;
                num5--;
                if(num5 < 0){
                    return false;
                }
            }
            else{
                if(num10 >0){
                    num10--;
                    num5--;
                }
                else{
                    num5 -= 3;
                }
                if(num5 < 0){
                    return false;
                }

            }
        }
        return true;
    }
}
// @lc code=end

