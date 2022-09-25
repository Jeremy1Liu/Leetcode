/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int count = 0;
        for(int i=len-1; i>=0; i--){
            if(s.charAt(i)>='a' && s.charAt(i)<='z' 
                || s.charAt(i)>='A' && s.charAt(i)<='Z'){
                count++;
            }
            else if(count>0){
                break;
            }
        }
        return count;
    }
}
// @lc code=end

