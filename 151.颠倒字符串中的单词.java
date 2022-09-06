/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 颠倒字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词；可以利用2的功能，控制好始末参数；
        reverseEachWord(sb);
        return sb.toString();
    }
    private StringBuilder removeSpace(String s){
        int start = 0;
        int end = s.length() - 1;
        while(s.charAt(start) == ' ') start++;
        while(s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while(start <= end){
            char c = s.charAt(start);
            if(c != ' ' || sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    private void reverseString(StringBuilder sb, int i, int j){
        while(i <= j){
            char temp = sb.charAt(i);
            sb.setCharAt(i++, sb.charAt(j));
            sb.setCharAt(j--, temp);

        }
    }

    //看的代码随想录，利用上一次的reverseString，非常棒的设计！
    private void reverseEachWord(StringBuilder sb){
        int start = 0;
        int end = 1;
        int n = sb.length();
        while(start < n){
            while(end<n && sb.charAt(end) != ' '){
                end++;
            }
            reverseString(sb, start, end-1);
            start = end+1;
            end = start +1;
        }
    }


}
// @lc code=end

