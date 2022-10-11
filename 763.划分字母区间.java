import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String s) {
        //这道题首先要明白划分的是什么.
        //"ababcbaca"全都在这个区间段中（区间段意思是这些字母的下标）
        //则首要方向是给所有字母设定最远的下标位置；
        //以此为标准，进行划分
        int[] hash = new int[27];
        for(int i=0; i<s.length(); i++){
            hash[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        
        int maxSubIndex = Integer.MIN_VALUE;
        int lastPartIndex = -1;
        for(int i=0; i<s.length(); i++){
            //比如说"ababcbaca"的hash记录中最大的为a的hash为9
            maxSubIndex = Math.max(maxSubIndex, hash[s.charAt(i) - 'a']);
            if(i == maxSubIndex){
                
                res.add(i - lastPartIndex);
                lastPartIndex = i;
                
            }
        }

        return res;

    }
}
// @lc code=end

