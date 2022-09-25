import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.prefs.BackingStoreException;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    //此题与39的差别在于去重，
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> res2 = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return res;
    }

    private void backTracking(int[] candidates, int target, int sum, int startIndex){
        if(sum == target){
            res.add(new ArrayList<>(res2));
            return;
        }

        //这里循环一定要剪枝，要不然通不过submit
        for(int i=startIndex; i<candidates.length && sum+candidates[i] <= target; i++){
            //这是这道题进行去重操作的核心！跳过同一树层使用过的元素。
            if(i>startIndex && candidates[i] == candidates[i-1]){
                continue;
            }
            sum += candidates[i];
            res2.add(candidates[i]);
            //i+1表示当前组内元素只用一次，不会无限次使用。
            backTracking(candidates, target, sum, i+1);
            
            sum -= res2.get(res2.size()-1);
            res2.remove(res2.size() - 1);
        }
    }
}
// @lc code=end

