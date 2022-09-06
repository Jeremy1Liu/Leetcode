/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for(int i : nums1) {//遍历数组1
            set1.add(i);
        }

        for(int i : nums2){//遍历数组2，查找元素是否在set1中，如果在则加入resSet;
            if(set1.contains(i)){
                resSet.add(i);
            }
        }

        //结果转换为int[]
        int[] res = new int[resSet.size()];
        int index = 0;
        for(int num : resSet){
            res[index++] = num;
        }

        return res;
    }
}
// @lc code=end

