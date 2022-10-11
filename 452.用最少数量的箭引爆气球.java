import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        //看的代码随想录的思路
        //此题的思路大概是这样，首先数组排序，便于后序操作
        //其次更新每个数据的右边界，只要有重叠就更新右边界。
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 1;
        for(int i=1; i<points.length; i++){
            if(points[i][0] > points[i-1][1]){ 
                //i的左坐标大于i-1的右坐标，则不挨着，需要加一只箭
                count++;
            }
            else{
                //气球i和i-1挨着，但是有不同的右边界，需要确定射箭的右边界。
                //就为所有挨着这些气球右边界中最小的一个，即为最左的；
                points[i][1] = Math.min(points[i][1], points[i-1][1]);
            }
        }

        return count;

    }
}
// @lc code=end

