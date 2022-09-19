import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Map<Character, Integer> hm = new HashMap<>();
        int max = 0;
        int left = 0;

        for(int i=0; i<s.length(); i++){
            
            if(hm.containsKey(s.charAt(i))) {
                //这里不懂，为什么要+1
                left = Math.max(left, hm.get(s.charAt(i))+1);
            }
            hm.put(s.charAt(i), i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }
}
// @lc code=end

