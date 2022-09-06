/*
 * @lc app=leetcode.cn id=1582 lang=java
 *
 * [1582] 二进制矩阵中的特殊位置
 */

// @lc code=start
class Solution {
    public int numSpecial(int[][] mat) {

        //参考的答案，就根据题目来判定；
        int r = mat.length, c = mat[0].length;
        int[] row = new int[r];
        int[] col = new int[c];

        //通过遍历，得到row 和col的值，并存入2个数组中；
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                row[i] += mat[i][j];
                col[j] += mat[i][j];
            }
        }

        int res = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1){
                    res++;
                }

            }
        }

        return res;


    }
}
// @lc code=end

