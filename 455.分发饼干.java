/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gl = g.length;
        int sl = s.length;
        int i=0, j=0;
        int count=0;
        while(i<gl && j<sl){
            if(s[j] >= g[i]){
                i++;
                j++;
                count++;
            }
            else{
                j++;
            }
        }
        return count;
    }
}
// @lc code=end

