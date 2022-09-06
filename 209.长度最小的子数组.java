/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int p1=0, p2=0, len = nums.length, sum=0, res= Integer.MAX_VALUE;
        for( ;p2 < len; p2++){
            sum += nums[p2];
            while(sum >= target){
                res = Math.min(res, p2-p1+1);
                sum -= nums[p1++];
            }
        }
        // while(p2 < len){
            
        //     sum += nums[p2++];
        //     //此处要用while！！！，而不是if，因为需要多次进行这个步骤
        //     while(sum >= target){
        //         res = Math.min(res, p2-p1);
        //         //利用Integer.MAX_VALUE来控制是否得到了真正需要的数据；
        //         sum -= nums[p1++];
        //     }
            

        //     // else{
        //     //     res = Math.min(res, p2-p1);
        //     //     //利用Integer.MAX_VALUE来控制是否得到了真正需要的数据；
        //     //     sum -= nums[p1++];
        //     // } 

        // }
        if(res == Integer.MAX_VALUE) res = 0;
        return res;
    }
}
// @lc code=end

