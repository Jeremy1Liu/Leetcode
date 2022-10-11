/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if(len <= 1) return len;


        int count = 1;
        int flag = 0;

        for(int i = 1; i < len; i++){
            if(flag == 0 &&  nums[i] - nums[i - 1] != 0 ){
                count++;
                flag = nums[i] - nums[i-1] > 0 ? 1 : -1;
            }
            else if(flag == 1 && nums[i] - nums[i - 1] < 0){
                count++;
                flag = -1;
            }
            else if(flag == -1 && nums[i] - nums[i - 1] > 0){
                count++;
                flag = 1;

            }
                
        }

        return count;
    }
}
// @lc code=end

