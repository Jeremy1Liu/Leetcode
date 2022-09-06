/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        //通过record【26】记录magzine中各个字符出现的次数；
        for( char c : magazine.toCharArray()){
            record[c - 'a']++;
        }
        //遍历ransomNote，在record中对应字符个数做--操作。
        for(char c: ransomNote.toCharArray()){
            record[c - 'a']--;

            //判定条件，如果次数小于零，则magzie中没有这个字符；
            if(record[c - 'a'] < 0){
                return false;
            }
        }

        return true;

    }
}
// @lc code=end

