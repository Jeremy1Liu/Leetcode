/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] sChar = s.toCharArray();
        int i;
        //按照下标每次增加2k来进行步进。
        //但是需要判断最后一个阶段的处理逻辑，以及边界条件；
        for( i=0; i < sChar.length; i += 2*k){
            if(i+k < sChar.length){
                reverse(sChar, i, i+k-1);
            }
            else{
                reverse(sChar, i, sChar.length-1);
            }
            
        }


        String res = new String(sChar);
        return res;
    }

    //定义翻转函数，输入值为字符数组char[], 起始下标，结束下标。注意边界条件；
    public void reverse(char[] ch, int start, int end){
        char temp;
        while(start < end) {
            temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }
}
// @lc code=end

