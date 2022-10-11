/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int sum=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= 0 && k>0){//把负数转换为正数
                sum += -nums[i];
                min = Math.min(min, -nums[i]);//记录最小数，用于转负；
                k--;
            }
            else if(nums[i] <= 0 && k<=0){
                sum += nums[i]; //如果k用完，则无需转换，直接加；
            }
            else if(nums[i] > 0 && k>0){
                sum += nums[i]; 
                min = Math.min(min, nums[i]);//如果k没用完，则目的还是找最小数
            }
            else{
                sum += nums[i]; //如果k用完，则无需转换，直接加；
            }

        }
        if(k%2 == 1) sum -= 2*min; //看k的奇偶性，如果为基数，则把最小数转为负。

        return sum;
    }
}
// @lc code=end

