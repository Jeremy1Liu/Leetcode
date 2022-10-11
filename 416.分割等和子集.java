import org.junit.Test;

/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 0) return true;
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum % 2 == 1) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];

        for(int i=0; i<n; i++){
            for(int j=target; j>=nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
            }
        }

        return dp[target] == target;
    }

}
// @lc code=end
@Test
public void test(){
    int[] nums = {1,5,5,11};
    System.out.println(canPartition(nums));
    
}