import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean flag = true;
    public List<List<Integer>> findSubsequences(int[] nums) {
        //if(nums.length == 0) return res.add(new ArrayList<>(path));
        backTracking(nums, 0);
        return res;
    }

    private void backTracking(int[] nums, int startIndex){
        if(path.size() > 1){
            res.add(new ArrayList<>(path));
        }

        //使用一个nums数组来记录数据是否使用过，去重用
        int[] used = new int[201];
        for(int i=startIndex; i<nums.length; i++){
            // if(path.size() == 0) {
            //     path.add(nums[i]);
            // }
            //这道题去重主要是使用used数组记录是否使用过；
            if(path.size()>0 && path.get(path.size()-1) >nums[i] 
                    || (used[nums[i]+100] == 1)){
                continue;
            }
            path.add(nums[i]);
            used[nums[i] + 100] = 1;
            backTracking(nums, i+1);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

