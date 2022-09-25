import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0){
            res.add(new ArrayList<>(path));
            return res;
        }

        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTracking(nums, 0);
        return res;
    }

    private void backTracking(int[] nums, int startIndex){
        res.add(new ArrayList<>(path));
        if(startIndex >= nums.length) return;

        for(int i=startIndex; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTracking(nums, i+1);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

