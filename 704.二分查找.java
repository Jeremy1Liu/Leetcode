/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length - 1;
        return helper(nums, l, r, target);

    }
    public int helper(int[] nums, int l, int r, int target){
        while(l <= r){
            int mid = l + (r-l)/ 2;
            if(nums[mid] == target) return mid; 
            else if(nums[mid] > target){
                return helper(nums, l, mid-1, target);
            }
            else {
                return helper(nums, mid+1, r, target);
            }
        }
        return -1;
    }
}
// @lc code=end

