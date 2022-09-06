/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char char1 = s.charAt(i);
            char char2 = t.charAt(i);
            if((map1.get(char1) != null && map1.get(char1) != char2) || (map2.get(char2) != null && map2.get(char2) != char1)){
                return false;
            }
            map1.put(char1, char2);
            map2.put(char2, char1);
        }
        return true;
    }
}
// @lc code=end

