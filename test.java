import java.util.Arrays;

public class test {
    public static void main(String[] args) {
         Solution so = new test().new Solution();
        System.out.println(so.combinationSum4( new int[] {3,1,4,2}, 4));

    }


    class Solution {
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target+1];
            dp[0] = 1; // 初始元素怎么设定；
            for(int j = 0; j<= target; j++){
                //对于特定的j，即背包容量值，遍历num[]数组，求出最大的排列和；
                //相当于爬楼梯，dp[j] = dp[j-nums[0]] + dp[j-nums[i]];
                //即扣除所有nums[i]之前所有的楼梯的数字，再加上最后一次楼梯。
                for(int i=0; i<nums.length; i++){
                    //对于nums[i]大于背包容量的情况，无需进行遍历，直接continue了
                    if(j >= nums[i]){
                        //对于当前的dp[j], 加上遍历所有nums[i]所得出的值dp[j - nums[i]]，
                        //dp[j - nums[i]]即为不含nums[i],背包j容量下最大的排列和；
                        //初始dp[i]为0，加上nums[0]值为1，
                        dp[j] = dp[j] + dp[j - nums[i]];
                    }
                    
                }
                System.out.println(Arrays.toString(dp));
            }
            return dp[target];
        }
    }
    
}


