import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        //看的代码随想录的思路
        //首先把数组按照左边界排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //建立存放数组的List，记得最后转换为int[][]
        List<int[]> res = new ArrayList<>();

        int len = intervals.length;
        //建立重叠区域的左右边界；
        int left = intervals [0][0];
        int right = intervals [0][1];
        for(int i=1; i<len; i++){
            //如果i的左边界，小于等于i-1节点的右边界，则说明重叠；
            //需要更新右边界；
            if(intervals[i][0] <= right){
                right = Math.max(right, intervals[i][1]);
            }
            //如果i的左边界，大于i-1节点的右边界，则说明无重叠。
            //把之前记录的上个重叠区域存入res，
            //需要更新下一个考察区域的left和right的值。
            else{
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        //最后一个节点的值还没有来得及记录，此时加入res；
        res.add(new int[]{left, right});
        
        //把Array转换为int[][]的方法；
        return res.toArray(new int[res.size()][2]);
    }
}
// @lc code=end

