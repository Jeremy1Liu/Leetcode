import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        //普通穷举法，效率太低。
        //使用厄拉多塞筛法，简称埃氏筛。可以大大提高效率
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);

        int count = 0;

        for(int i = 2; i < n; i++){
            if(isPrime[i] == 1){
                count++;
                if((long)i*i < n){
                    for(int j = i*i; j < n; j+=i){
                        isPrime[j] = 0;
                    }
                }
                

            }
            
        }

        return count;

    }




    //     if(n==0 || n==1) return 0;

    //     int count = 0;
    //     for(int i=2; i<n; i++){
    //         if(isPrime(i)) count++;
    //     }
    //     return count;

    // }

    // private boolean isPrime(int i) {
    //     for(int j=2; j*j<=i ; j++){
    //         if(i%j == 0) return false;
    //     }
    //     return true;
    // }
}
// @lc code=end

