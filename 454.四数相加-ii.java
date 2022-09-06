/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        //看答案学会的解法
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        int res = 0;
        for( int a: nums1){
            for(int b: nums2){
                temp = a+b;
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp)+1);
                }
                else{
                    map.put(temp, 1);
                }
            }
        }

        for(int i: nums3){
            for(int j : nums4){
                temp = i + j;
                if(map.containsKey(0-temp)){
                    res += map.get(0-temp);
                }
            }
        }

        return res;
    }
}
// @lc code=end

