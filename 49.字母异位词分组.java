import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for(String str : strs){
            //相同的序列，比较标准是排序后比较。
            //所以利用一个char[] cur来存放，排序，并把此排序的当作key
            //每次核查，getOrDefault, 如果没有此key，就存入key，并且
            char[] cur = str.toCharArray();
            Arrays.sort(cur);
            String key = new String(cur);

            //这是答案中的写法,不好理解
            // List<String> list = hm.getOrDefault(key, new ArrayList<>());
            // list.add(str);
            // hm.put(key, list);

            //其实就是如下意思,如果不包含,则创建新映射,并添加到Map;
            //如果包含,则直接在value的List中添加String,更新value;
            if(!hm.containsKey(key)){
                List<String> value = new ArrayList<String>();
                value.add(str);
                hm.put(key, value);
            }
            else{
                hm.get(key).add(str);
            }
            
        }

        return new ArrayList<List<String>>(hm.values());
    }
}
// @lc code=end

