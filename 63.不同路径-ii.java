/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][]res = new int[m][n];

        for(int i=0; i<m && obstacleGrid[i][0] == 0; i++){
            res[i][0] = 1;
        }


        for(int j=0; j<n; j++){
            if(obstacleGrid[0][j] == 1 ){
                break;
            }
            else{
                res[0][j] = 1;
            }
        }




        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                //将障碍点设置为0，就是路径为0；
                if(obstacleGrid[i][j] == 1){
                    res[i][j] = 0;
                }
                else{
                    res[i][j] = res[i-1][j] + res[i][j-1];                   
                }
                
            }
        }

        return res[m-1][n-1];

    }
}
// @lc code=end

