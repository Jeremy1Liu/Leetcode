import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    //学习：爱学习的饲养员的回溯算法；
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTracking(n, result, 0, 0, "");
        return result;
    }

    private void backTracking(int n, List<String> result, int left, int right, String str){
        if(right > left){
            return;
        }
        if(left==n && right ==n){
            result.add(str);
            return;
        }

        if(left < n){
            backTracking(n, result, left+1, right, str+"(");
        }
        if(right < left){
            backTracking(n,result, left, right+1, str+")");
        }
    }
}
// @lc code=end

