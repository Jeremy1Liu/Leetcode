import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    List<List<String>> res = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return res;

    }

    private void backTracking(String s, int startIndex){
        //如果起始位置大于s的长度，说明找到了一组切割方案；
        if(startIndex >= s.length()){
            res.add(new ArrayList<>(deque));
            return;
        }

        for(int i = startIndex; i < s.length(); i++){
            if(isPalindrome(s, startIndex, i)){
                //这一行需要是i+1, 因为左闭右开；
                String str = s.substring(startIndex, i+1);
                deque.addLast(str);
            }
            else continue;

            backTracking(s, i+1);
            deque.removeLast();
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        for(int i =start, j=end; i<j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

