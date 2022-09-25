import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> resPart = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //首先要进行排序；
        Arrays.sort(candidates);
        findComb(candidates, target, 0, 0);
        return res;
    }

    private void findComb(int[] candidates, int target, int sum, int startIndex){

        if(sum == target){
            res.add(new ArrayList<>(resPart));
            return;
        }
        for(int i = startIndex; i<candidates.length; i++){
            if(sum+candidates[i] > target) break;
            resPart.add(candidates[i]);
            findComb(candidates, target, sum+candidates[i], i);
            resPart.remove(resPart.size() - 1);
        }
    }
}
// @lc code=end

