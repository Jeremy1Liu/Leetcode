/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        //循环不变量原则，根据代码随想录抄写！！！
        int loop = 0;//控制循环次数，总次数为n/2
        int[][] res = new int[n][n];
        int start = 0;//每次循环的开始点（start, start)
        int count = 1;//定义填充数字
        int i,j;

        while(loop++ < n/2){
            for(j=start; j<n-loop; j++){
                res[start][j] = count++;
            }
            for(i=start; i<n-loop; i++){
                res[i][j] = count++;
            }
            for( ; j> start ;j--){
                res[i][j] = count++;
            }
            for( ; i> start; i--){
                res[i][j] = count++;
            }
            start++;
        }

        if(n % 2 == 1){
            res[start][start] = count;
        }
        return res;


    }
}
// @lc code=end

