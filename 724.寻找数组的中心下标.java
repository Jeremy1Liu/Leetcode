/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心下标
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {
        int total=0;
        for(int i=0; i<nums.length; i++) total+= nums[i];

        int left = 0;
        for(int i=0; i<nums.length; i++){
            left += i==0 ? 0 : nums[i-1];
            //相当于添加了一个-1位置的值为0的元素；
            int right = total - nums[i] - left;
            if(left == right) return i;
        }
        return -1;
    }
}
// @lc code=end

