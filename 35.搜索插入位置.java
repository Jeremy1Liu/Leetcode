/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left=0; 
        int right = n-1;
        int ans = n;
        int mid;
        while(left<=right){
            mid = left+(right-left)/2;
            if(target > nums[mid]) left = mid+1;
            else if(target < nums[mid]) {
                ans = mid;
                right= mid-1;
            }
            else return mid;
        }

        return ans;

    }
}
// @lc code=end

