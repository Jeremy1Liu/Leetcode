/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        //学习代码随想录上的方法
        if(nums.length == 1) return 0;
        int nextDistance=0; //记录数据，为下一跳做准备。保证nextD为最优最远方案。
        int curDistance =0; //记录当前能达到哪个下标的位置。
        int ans=0;
        for(int i=0; i<nums.length; i++){
            nextDistance = Math.max(nums[i]+i, nextDistance);
            if(i == curDistance){//这一跳步数用完，需要动用储备步数来下一跳
                if(curDistance >= nums.length-1){//到终点
                    break;
                }
                ans++;//增加一跳
                curDistance = nextDistance;//这一跳最远能达到的index位置；
                

            }
        }
        return ans;

    }
}
// @lc code=end

