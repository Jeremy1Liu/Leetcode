/*
 * @lc app=leetcode.cn id=881 lang=java
 *
 * [881] 救生艇
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l=0;
        int r=people.length - 1;
        int count = 0;
        while(l <= r){
            if(people[r] + people[l] <= limit){
                l++;
            }

                r--;
                count++;
            
        }
        return count;

    }
}
// @lc code=end

