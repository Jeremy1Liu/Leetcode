import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    //这道题与77题，组合，几乎一样，都是使用回溯的方法
    //这道题需要额外加上一个判定==n的操作。
    // List<List<Integer>> res = new ArrayList<>();
    // List<Integer> path = new ArrayList<>();
    // public List<List<Integer>> combinationSum3(int k, int n) {
    //     backTracking(k, n, 1);
    //     return res;
    // }

    // private void backTracking(int k, int n, int startIndex){
    //     if(path.size() == k){
    //         int sum=0;
    //         for(int i : path){
    //             sum += i;
    //         }
    //         if(sum == n){
    //             res.add(new ArrayList<>(path));
    //         }
    //         return;

    //     }

    //     for(int i = startIndex; i <= 9; i++){
    //         path.add(i);
    //         backTracking(k, n, i+1);
    //         path.remove(path.size()-1);
    //     }
    // }


    //方法2，看的代码随想录
    //这种方法在回溯时自带了sum的变量，效率更高。
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        //其中1是startIndex, 0是sum的值；
        backTracking(k, n, 1, 0);
        return res;
    }

    private void backTracking(int k, int n, int startIndex, int sum){
        if(sum > n) return;
        if(path.size() == k){
            if(sum == n) res.add(new ArrayList<>(path));
            return;
        }

        //剪枝操作，如果后面的数不足k个，则无需再循环；
        for(int i=startIndex; i <= 9 - (k-path.size()) + 1; i++){
            path.add(i);
            sum += i;
            // 注意i+1调整startIndex
            backTracking(k, n, i+1, sum);
            sum -= path.get(path.size() -1 );
            path.remove(path.size() - 1);
        }
    }

}
// @lc code=end

