/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        //lc13
        int sum = 0;
        //通过getValue函数，输入char的值，输出对应的int;
        int pre = getValue(s.charAt(0));
        sum = pre;

        //当个位置的值只有2种可能，如果左值更大，则加上
        //如果左值更小，则减去左值。
        for(int i = 1; i < s.length(); i++){
            int num = getValue(s.charAt(i));
            if(pre < num){
                //因为上次加过pre，因此这里要减去2次。
                sum = sum + num - 2 * pre;
            } 
            else{
                sum = sum + num;
            }
            //每次循环都用pre来存储上次的值；
            pre = num;
        }
        return sum;
    }

    private int getValue(char charAt) {
        int res = 0;
        if(charAt == 'I') res = 1; 
        else if(charAt == 'V') res = 5; 
        else if(charAt == 'X') res = 10;
        else if(charAt == 'L') res = 50;
        else if(charAt == 'C') res = 100; 
        else if(charAt == 'D') res = 500;
        else if(charAt == 'M') res = 1000;

        return res;
    }
}
// @lc code=end

