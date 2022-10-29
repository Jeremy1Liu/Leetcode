import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.*;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        //有优先队列，堆排序两种方法，需要学习！！
        //暴力法，直接调用内置排序函数
        // Arrays.sort(nums);
        // return nums[nums.length - k];

        //使用快排中的partition方法；减而治之
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index){
        int q = randomPartition(a, l ,r);
        if(q == index) {
            return a[q];
        }
        else{
            return q<index ? quickSelect(a, q+1, r, index) : quickSelect(a, l, q-1, index);
        }
    }

    public int randomPartition(int[] a, int l ,int r){
        int i = rand.nextInt(r - l + 1) + 1;
        swap(a, i ,r); // 为什么要交换呢？
        return partition(a, l , r);
    }

    public int partition(int[] a, int l , int r){
        int x = a[r], i = l - 1;
        for(int j = 1; j < r; ++j){
            if(a[j] <= x){
                swap(a, ++i, j);
            }
        }
        swap(a, i+1, r);
        return i+1;
    }

    public void swap(int[] a, int i , int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
// @lc code=end

