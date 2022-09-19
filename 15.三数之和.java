import java.util.ArrayList;
import java.util.Arrays;

import javax.smartcardio.ResponseAPDU;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //这种双指针法的前提是排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;

        for(int i=0; i<len-2; i++){
            //使用双指针的方法；
            int left = i+1, right = len-1;

            if(i>0 && nums[i]==nums[i-1]){
                //跳过这次循环，直接进行i++的下一次循环；
                continue;
            }
            while(left<right){
                if(nums[i]+nums[left]+nums[right] > 0){
                    right--;
                }
                else if(nums[i]+nums[left]+nums[right] < 0){
                    left++;
                }
                else{
                    List<Integer> ans = new ArrayList<>();
                    
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    res.add(ans);
                    left++;
                    right--;

                    while(right>left && nums[left] == nums[left-1]) left++;
                    while(right>left && nums[right] == nums[right+1]) right--;
                    

                }
            }

        }
        return res;

    }
}
// @lc code=end

