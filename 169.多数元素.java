/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        //采用排序，取index中间数的方法，时间复杂度为nlogn
        //采用哈希表，时间复杂度为O n, 空间复杂度为O n,
        //采用摩尔投票法，时间复杂度为O n, 空间复杂度为O 1；
        //相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。

        int vote = nums[0];
        int count = 1;
        for(int i=1; i<nums.length; i++){
            //如果count==0，说明前面部分没有出现众数（出现概率大于50%），需要重置vote和count；
            if(count == 0){
                vote = nums[i];
                count = 1;
                continue;
            }
            //如果后面出现的数与之前的众数相同，count++
            else if(nums[i] == vote) count++;
            //如果不同，count--，相当于不同的数抵消一次；
            else count--;
        }
        return vote;



    }
}
// @lc code=end

