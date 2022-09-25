import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n,k,1);
        return res;
    }
    private void backTracking(int n, int k, int startIndex){

        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;

        }
        for(int i = startIndex; i <= n; i++){
            path.add(i);
            backTracking(n, k, i+1);
            path.remove(path.size()-1);
        }
    }
}
// @lc code=end

