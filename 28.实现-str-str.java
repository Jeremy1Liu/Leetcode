/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int i=0, j=0;
        while(i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            else{
                i=i-j+1;
                j=0;
            }
            if(j== needle.length()) return i-j;

        }
        
        return -1;
    }
}
// @lc code=end

