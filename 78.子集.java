import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return res;
    }

    private void backTracking(int[] nums, int startIndex){
        res.add(new ArrayList<>(path));
        if(startIndex >= nums.length) return;
        for(int i=startIndex; i < nums.length; i++){
            path.add(nums[i]);
            backTracking(nums, i+1);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

