/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int lens = height.length;
        int left = 0;
        int right = lens-1;
        int sum = Math.min(height[left], height[right]) * (right - left);
        while(left < right){
            //左侧指针移动一位
            // int leftArea = Math.min(height[left+1], height[right]) 
            //                 * (right -left - 1);
            // int rightArea= Math.min(height[left], height[right-1]) * (right -1 -left);
            // if(leftArea > rightArea){
            //     left++;
            //     sum = Math.max(sum, leftArea);
            // }
            // else{
            //     right--;
            //     sum = Math.max(sum, rightArea);
            // }

            //选择左右指针中高度更低那一个，进行步进；
            if(height[left] < height[right]){
                left++;
                
            }
            else{
                right--;
            }
            sum = Math.max(sum, Math.min(height[left], height[right])*(right-left));
            
        }
        return sum;
    }
}
// @lc code=end

