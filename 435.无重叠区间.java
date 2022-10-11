/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //这道题参考452 用最少的箭引爆气球来做的；
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int arrow = 1;
        for(int i=1; i<intervals.length; i++){
            //区别在于，这里要取大于等于，因为等于在这里也算不重叠的区间；
            if(intervals[i][0] >= intervals[i-1][1]){
                arrow++;
                
            }
            //如果小于，则算是重叠区间。则更新i的右区间位置，使之达到这一批重叠区间的最左的右位置。
            //此时，arrow没有++，则证明最后的return的结果更大，需要移除的区间更多；
            else{
                intervals[i][1] = Math.min(intervals[i][1], intervals[i-1][1]);
            }
        }

        return intervals.length - arrow;
    }
}
// @lc code=end

