/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length-1;
        int n = matrix[0].length-1;
        
        int leftM = 0;
        
        //先找寻对应的行
        while(leftM < m) {
            int midM = leftM + (m-leftM)/2;
            if(matrix[midM][0] > target) {
                m = midM-1;
            }
            else if(matrix[midM][n] < target){
                leftM = midM + 1;
            }
            else{
                leftM = midM;
                break;
            }
        }

        //找到了对应的行，再使用二分查找
        int leftN = 0;
        while(leftN < n){
            int midN = leftN + (n-leftN)/2;
            if(matrix[leftM][midN] < target ){
                leftN = midN + 1;
            }
            else if(matrix[leftM][midN] > target ){
                n = midN-1;
            }
            else{
                leftN = midN;
                break;
            }
        }

        return matrix[leftM][leftN] == target;

    }
}
// @lc code=end

