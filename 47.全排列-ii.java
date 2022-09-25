import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);
        backTracking(nums, used);
        return res;
    }

    private void backTracking(int[] nums, boolean[] used){
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            //use this if to avoid the duplication
            //去重的三个条件，i>0; 避过第一个yuan'su
            if(i>0 && nums[i]==nums[i-1] && used[i-1]==false){
                continue;
            }

            // use the used[] to record the usage of each item.
            if(used[i] == false){
                used[i] = true;
                path.add(nums[i]);
                backTracking(nums, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}

// @lc code=end

