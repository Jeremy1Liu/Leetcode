import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        //这是自己写出来的方法
        // if(x<0) return false;
        // else if(x==0) return true;
        // List<Integer> list = new ArrayList<>();
        // while(x>0){
        //     int remain = x%10;
        //     list.add(remain);
        //     x /= 10;
        // }
        // int n = list.size();
        // int left=0, right = n-1;
        // while(left<right){
        //     if(list.get(left++) != list.get(right--)){
        //         return false;
        //     }
        // }
        // return true;

        //这是LC上面的解法
        if(x<0) return false;
        int reverseX=0;
        int num = x;
        while(num != 0){
            reverseX = reverseX*10 + num%10;
           num /= 10;
        }

        return reverseX == x;

    }

}
// @lc code=end

