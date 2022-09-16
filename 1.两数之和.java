import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        //利用HashMap有键值对的特性，存储数据信息和位置i的信息
        //然后通过target - nums[i] 再来找到对应的j的位置；
        HashMap<Integer, Integer> hMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(hMap.containsKey(target - nums[i])){
                res[1] = i;
                res[0] = hMap.get(target - nums[i]);
                break;
            }
            hMap.put(nums[i], i);
        }


        return res;
    }
}
// @lc code=end

