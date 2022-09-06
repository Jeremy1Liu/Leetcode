/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        for(int i=0; i<sc.length; i++){
            count[sc[i] - 'a']++;
        }
        for(int i=0; i<tc.length; i++){
            count[tc[i] - 'a']--;
        }

        boolean res = true;
        for(int i : count){
            if(i != 0) res = false;
        }
        return res;
    }
}
// @lc code=end

