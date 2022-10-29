/*
 * @lc app=leetcode.cn id=1456 lang=java
 *
 * [1456] 定长子串中元音的最大数目
 */

// @lc code=start
class Solution {
    public int maxVowels(String s, int k) {
        int l=0, r=k-1;
        int[] slideWindow = new int[k];
        int count = 0;
        int i;
        for(i=0; i<k; i++){
            if(s.charAt(i) == 'a' || 
            s.charAt(i) == 'e' ||
            s.charAt(i) == 'i' ||
            s.charAt(i) == 'o' ||
            s.charAt(i) == 'u'){
                count++;
            }
        }
        
        int max = count;
        for(i=k; i<s.length(); i++, l++){
            if(s.charAt(i) == 'a' || 
            s.charAt(i) == 'e' ||
            s.charAt(i) == 'i' ||
            s.charAt(i) == 'o' ||
            s.charAt(i) == 'u'){
                count++;
            }
            if(s.charAt(l) =='a' || 
            s.charAt(l) == 'e' ||
            s.charAt(l) == 'i' ||
            s.charAt(l) == 'o' ||
            s.charAt(l) == 'u'){
                count--;
            }
            max = Math.max(max, count);
        }

        return max;

    }
}
// @lc code=end

