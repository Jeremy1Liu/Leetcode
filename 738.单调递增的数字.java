/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int n) {
        //这道题算是自己做出来的
        if(n < 10) return n;
        String str = Integer.toString(n);
        int endIndex=-1;

        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i)-str.charAt(i+1) > 0) {
                endIndex = i;
                //找到第一个大于后面数，就可以停止。
                //之前忘记加break,导致不成功；在后面的大于才停止，不行。
                break;
            }
        }
        if(endIndex == -1) return n;

        int sum = 0;
        boolean flag = true;
        for(int i=0; i<str.length(); i++){
            if(flag && str.charAt(i) == str.charAt(endIndex)){
                sum = sum*10 + (str.charAt(i) - '1');
                flag = false;
            }
            else if(!flag){
                sum = sum*10 + 9;
            }
            else sum = sum*10 + (str.charAt(i) - '0');
        }

        return sum;
    }
}
// @lc code=end