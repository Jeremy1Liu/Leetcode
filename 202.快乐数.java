/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        //抄写答案写的；主要有2个部分，1计算出下一个数；2判断是否有循环，利用Hash Set来判断。
        Set<Integer> set1 = new HashSet<>();
        while( n != 1 && !set1.contains(n)){
            set1.add(n);
            n = getNextNumber(n);
        }
        return n==1 ;
    }

    public int getNextNumber(int n){
        int sum = 0;
        while(n > 0){
            sum += (n%10) * (n%10);
            n /= 10;
        }
        return sum;
    }
}
// @lc code=end

