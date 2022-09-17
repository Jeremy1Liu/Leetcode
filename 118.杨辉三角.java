import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        //两层List的定义方法
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for( int i=0; i<numRows; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i) row.add(1);
                //这里的规律总结比较精妙；
                else{
                    row.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
                }
                
            }
            res.add(row);
        }

        return res;

    }
}
// @lc code=end

