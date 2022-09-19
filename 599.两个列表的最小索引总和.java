import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=599 lang=java
 *
 * [599] 两个列表的最小索引总和
 */

// @lc code=start
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hm1 = new HashMap<>();
        int l1 = list1.length, l2 = list2.length;

        for(int i=0; i<l1; i++){
            hm1.put(list1[i], i);
        }

        List<String> ans = new ArrayList<>();
        int min = 3000;
        for(int j=0; j<l2; j++){
            String s = list2[j];
            if(!hm1.containsKey(s)) continue;
            else{
                int sum = j + hm1.get(s);
                if( sum < min){
                    min = sum;
                    ans.clear();
                    
                    ans.add(s);
                }
                else if(sum == min){
                    ans.add(s);
                }
                else{
                    continue;
                }
            }
           
        }
        String[] res = new String[ans.size()];
        ans.toArray(res);
        return res;       

    }
}
// @lc code=end

