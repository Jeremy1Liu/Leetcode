/*
 * @lc app=leetcode.cn id=1991 lang=java
 *
 * [1991] 找到数组的中间位置
 */

// @lc code=start
class Solution {
    public int findMiddleIndex(int[] nums) {
        int len = nums.length;

        int sum=0;
        for(int num : nums){
            sum+= num;
        }
        int sum2=0;
        for(int i=0; i<len; i++){
            sum2+=nums[i];
            if(2* sum2 == sum) return i
        }


    }
}
// @lc code=end

