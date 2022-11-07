import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] 水果成篮
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        //如果滑动窗口有2种及一下的水果，右指针滑动；
        //如果滑动窗口有2种以上的水果，左指针滑动，直到水果变成2种以下；
        //如何统计水果的种类出现次数，可以用哈希表存储次数；
        int lo=0, hi = 0;
        int res = 0;

        //hm中存储2种水果的个数
        Map<Integer, Integer> hm = new HashMap<>();
        while(hi < fruits.length){
            hm.put(fruits[hi], hm.getOrDefault(fruits[hi], 0) + 1);
            hi++;
            //当水果种类超过2种，就循环减去左指针的水果，直到某个key的value为0，意味着水果变为2种。
            while(hm.size() > 2){
                hm.put(fruits[lo], hm.get(fruits[lo])-1);
                if(hm.get(fruits[lo]) == 0){
                    hm.remove(fruits[lo]);
                }
                lo++;
            }
            res = Math.max(res, hi - lo);
        }

        return res;

    }
}
// @lc code=end

