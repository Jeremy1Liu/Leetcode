import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        //原理就是，只有边界值才计算，进行循环找最长序列。中间的值不用管，必小于边界值。
        //这时，可以再缩减到只有下边界值a，按照步进寻找a++的值, 如果有，则继续循环，count++；
        //下边界值的判定条件为，！hset.contains(a-1); 
        //直到没有的时候，这部分循环终止，得到一个part-max的值。
        Set<Integer> hset = new HashSet<>();
        for(int num : nums){
            hset.add(num);
        }

        int count=0, max = 0;
        for(int num : hset){
            //判定只有找到了连续序列的下边界值，才进行统计和计算
            if(!hset.contains(num-1)) {
                count = 1;
                int cur = num;
                while(hset.contains(++cur)){
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;

    }
}
// @lc code=end

