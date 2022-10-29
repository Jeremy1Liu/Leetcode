/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        //采用二分法查找，找到必定存在的山峰最高点
        //因为-1和nums.length位置都是负无穷，因此一定存在一个峰值。
        int l = 0, r = nums.length - 1;
        while(l < r){
            int mid = l + ((r - l)>>1);
            if(nums[mid] > nums[mid+1]){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return l;

    }
}
// @lc code=end

