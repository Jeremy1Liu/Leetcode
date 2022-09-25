import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backTracking(nums);
        return res;

    }

    private void backTracking(int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0; i< nums.length; i++){
            //如果path中已经有这个数值，则跳过；
            if(path.contains(nums[i])){
                continue;
            }

            path.add(nums[i]);
            backTracking(nums);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

