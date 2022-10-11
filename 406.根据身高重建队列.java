import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //这道题完全看代码随想录，sort方法有点新奇
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            else return b[0] - a[0];
        });

        List<int[]> que = new LinkedList<>();

        for(int[] p : people){
            //LinkedList add(int index, E element);
            que.add(p[1], p);
        }

        return que.toArray(new int[people.length][]);

    }
}
// @lc code=end

