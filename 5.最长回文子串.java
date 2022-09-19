/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        //对称子串采用中心扩散法
        int strLen = s.length();
        if(strLen<2) return s;

        char[] ch = s.toCharArray();
        int left, right, res1=0, res2=0, max=0;
        int len;
        for(int i=0; i<strLen; i++){
            len = 1;
            left = i-1; right = i + 1;
            
            while(left>=0 && ch[i] == ch[left]) {
                left--;
                len++;
            }
            while(right<=s.length()-1 && ch[i] == ch[right]){
                right++;
            } 
            while(left>=0 && right <= strLen-1 && ch[left] == ch[right]){
                len+=2;
                left--;
                right++;
            }
            
            if(len > max){
                res1 = left+1;
                res2 = right-1;
                max = len;
            }
        }
        return s.substring(res1, res2+1);

    }
}
// @lc code=end

