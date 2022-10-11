import java.util.List;

/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length()-1;
        int lenB = b.length()-1;
        int sum = 0;
        int carry = 0;
        //从右向左计算，因此从尾向头遍历；
        while(lenA>=0 || lenB>=0){
            sum = carry;
            sum += lenA >= 0? a.charAt(lenA) - '0' : 0;
            sum += lenB >= 0? b.charAt(lenB) - '0' : 0;

            carry = sum/2;
            sum %= 2;
            lenA--; lenB--;
            sb.append(sum);

        }
        if(carry == 1) sb.append(1);

        //StringBuilder不能从append from start, 所以使用reverse方法；
        return sb.reverse().toString();
    }
}
// @lc code=end

