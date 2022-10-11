/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        //相同的字符，异或运算一次，直接成为0，则单独的字符最后留了下来
        //奇怪的点是，使用^= 没事，但是使用res = (char) (res ^ cs);必须强制类型转换
        char res = 'a' ^ 'a';
        for(char cs : s.toCharArray()){
            //res ^= cs;
            res = (char) (res ^ cs);
        }
        for(char ct : t.toCharArray()){
            res ^= ct;
        }
        return res;
    }
}
// @lc code=end

