import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // //根据左闭右开的原则，每一圈遵循循环不变量
        // int start = 0;
        // int m = matrix.length, n = matrix[0].length;
        // List<Integer> res = new ArrayList<>();
        // int i, j;
        // int loop=0;
        // //如下是一定满足四条边的情况
        // while(loop < m/2 && loop < n/2){
        //     loop++;
        //     for(i=start, j = start; j < n-loop; j++){
        //         res.add(matrix[i][j]);
        //     }
        //     for(i = start; i< m-loop; i++){
        //         res.add(matrix[i][j]);
        //     }
        //     for( ; j>start; j--){
        //         res.add(matrix[i][j]);
        //     }
        //     for( ; i>start; i--){
        //         res.add(matrix[i][j]);
        //     }
        //     start++;
        // }
        // //循环结束后，需要判定，是否再遍历最后中间的元素
        // //如果行数少，且为单数行，需要遍历中间的元素，从左向右遍历
        // if(m<=n && m%2 == 1){
        //     for(j = start; j < n-loop; j++){
        //         res.add(matrix[start][j]);
        //     }
        // }
        // //如果列数少，且为单数列，需要遍历中间的元素，从上到下遍历；
        // else if(m>=n && n%2 == 1){
        //     for(i = start; i< m-loop; i++){
        //         res.add(matrix[i][start]);
        //     }
        // }

        // return res;


        //参考LC上的方法：
        List<Integer> res = new ArrayList<>();
        int startX=0, startY=0 ; //赋值上下左右边界
        //m是纵向高度，n是横向宽度；
        int m = matrix.length-1, n = matrix[0].length-1;
        //相当于用四个边界不断缩减来控制循环
        //循环结束条件即为，四个边界产生重叠，此时，break;
        while(true){
            //横坐标从左到右，把++startY；
            for(int i=startX; i<=n; i++) res.add(matrix[startY][i]);
            if(++startY > m) break;//相当于把起始行去除，因此起始startY++//上边界++；
            //纵坐标从上到下，把右边界缩减。--n
            for(int i=startY; i<=m; i++) res.add(matrix[i][n]);
            if(--n < startX) break;//右边界--，需要不小于左边界
            //横坐标从右到左，下边界缩减，--m
            for(int i=n; i>=startX; i--) res.add(matrix[m][i]);
            if(--m < startY) break;//下边界--
            //纵坐标从下到上，左边界缩减。++startX;
            for(int i=m; i>=startY; i--) res.add(matrix[i][startX]);
            if(++startX > n) break;//左边界++
        }
        return res;

    }
}
// @lc code=end

