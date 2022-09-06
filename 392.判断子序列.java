/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();

        int i=0, j=0;
        if(arrS.length == 0) return true;

        while( j<arrT.length && i<arrS.length ){
            if(arrS[i] == arrT[j]){
                if(i == arrS.length-1) return true;
                i++; j++;
            }
            else j++;
        }

        // for( ; j<arrT.length && i<arrS.length; ){
        //     if(arrS[i] == arrT[j]){
        //         if(i == arrS.length-1) return true;
        //         i++; j++;
        //     }
        //     else j++;

        // }
        return false;
    }
}
// @lc code=end

