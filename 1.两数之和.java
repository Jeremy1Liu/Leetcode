/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map1 = new HashMap<>();

        int[] res = new int[2];

        for(int i=0; i < nums.length; i++){
            if(map1.containsKey(target - nums[i])) {
                res[1] = i;
                res[0] = map1.get(target - nums[i]);
                break;
            }
            map1.put(nums[i], i);
        }

        return res;
    }
}
// @lc code=end

