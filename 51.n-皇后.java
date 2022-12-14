import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    //看的代码随想录抄写的；
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for(char[] c : chessboard){
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessboard);
        return res;
    }

    private void backTrack(int n, int row, char[][] chessboard){
        //递归终止条件
        if(row == n){
            res.add(Array2List(chessboard));
            return;
        }
        for(int col=0; col<n; ++col){
            if(isValid(row, col, n, chessboard)){
                chessboard[row][col] = 'Q';
                backTrack(n, row+1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private List Array2List(char[][] chessboard){
        List<String> list = new ArrayList<>();

        for(char[] c : chessboard){
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public boolean isValid(int row, int col, int n, char[][] chessboard){
        //检查列（行不用检查）
        for(int i=0; i<row; ++i){
            if(chessboard[i][col] == 'Q'){
                return false;
            }
        }
        //检查45度对角线
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(chessboard[i][j] == 'Q'){
                return false;
            }
        }
        //检查135度对角线
        for(int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++){
            if(chessboard[i][j] == 'Q'){
                return false;
            }

        }
        return true;
    }
}
// @lc code=end

