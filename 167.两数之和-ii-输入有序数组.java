/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //使用头尾两个指针，如果和较小，则lo++, 如果和较小，则hi--；
        int lo=0, hi = numbers.length-1;
        while(lo<hi){
            int sum = numbers[lo] + numbers[hi];
            if(sum < target) lo++;
            else if(sum > target) hi--;
            else break;

        }
        return new int[] {lo+1, hi+1};

    }
}
// @lc code=end

