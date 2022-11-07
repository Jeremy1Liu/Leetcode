/*
 * @lc app=leetcode.cn id=1668 lang=java
 *
 * [1668] 最大重复子字符串
 */

// @lc code=start
class Solution {
    public int maxRepeating(String sequence, String word) {
        int ans=0;
        int count=0;
        boolean flag = false;
        for(int i=0; i<sequence.length(); ){
            //substring中的两个参数是左开右闭的参数；
            //要求的是连续重组子字符串，
            // 如下算法只能通过99%的测试案例，通不过1个测试案例；
            //增加flag参数后，可以通过100%的测试案例。
            if(i+word.length()<=sequence.length() && sequence.substring(i, i+word.length()).equals(word)){
                count++;
                ans = Math.max(ans, count);
                i += word.length();
                flag = true;
            }
            else if(flag){
                //首次没有通过substring的对比时，把位置返回到i - word.length() + 1
                i = i - word.length() + 1;
                count=0;
                flag = false;
            }
            else{
                i++;
            }
        }
        return ans;

        //参考的答案，因为是求连续的重复字符串，所以直接扩大子字符串就可以。
        //然后调用contains函数；
        // String s = word;
        // while(sequence.contains(s)){
        //     ans++;
        //     s+=word;
        // }
        //return ans;

    }
}
// @lc code=end

