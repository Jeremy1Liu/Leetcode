import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int lens = nums1.length;
        int[] res = new int[lens];
        Arrays.fill(res, -1);
        

        Map<Integer, Integer> hMap = new HashMap<>();
        for(int i=0; i< nums1.length; i++){
            //通过nums[i]来在nums2中找对应的值，i来填充res相应的位置；
            hMap.put(nums1[i], i);
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for(int i=1; i<nums2.length; i++){
            if(nums2[i] <= nums2[stack.peek()]){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                    //如果这个peek值在hMap中，则说明这个值也在nums1中，
                    if(hMap.containsKey(nums2[stack.peek()])){
                        int index = hMap.get(nums2[stack.peek()]);
                        //通过Map找到这个值的index, 通过循环找到较大值nums2[i];
                        res[index] = nums2[i];
                    }
                    stack.pop();
                }
                stack.add(i);
            }
        }
        return res;



    }
}
// @lc code=end

