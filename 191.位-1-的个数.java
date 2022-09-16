/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //使用int的计算不行。需要使用位运算。
        // int res = 0;
        // if(n<0) n += Math.pow(2,32);
        // while(n>0){
        //     res += n % 2;
        //     n /= 2;
        // }

        // return res;

        // int res = 0;
        // //这种方法知道输入位数是多少位，可以有固定的循环次数；
        // for(int i = 0; i < 32; i++){
                //位运算的，与运算；
        //     res += n & 1;
        //     n>>=1;
        // }
        // return res;

        int res = 0;
        while(n != 0){
            res++;
            //可以通过证明，不过n是正数还是负数，
            //都可以通过位运算n&(n-1),把最右边一位1变成0；
            n = n & (n-1);
        }
        return res;


        
    }
}
// @lc code=end

