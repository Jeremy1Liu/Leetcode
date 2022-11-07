/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int cnt = 0;
        while(temp != null) {
            temp = temp.next;
            cnt++;
        }
        int mode = cnt % k;
        int size = cnt / k;
        ListNode[] res = new ListNode[k];
        temp = head;

        for(int j=0; temp!=null && j<k; j++){
            res[j] = temp;
            int partsize = size + (mode-- > 0 ? 1 : 0);

            //因为i是0的时候，temp已经走到第二个位置了。因此需要把partsize-1；
            for(int i=0; i < partsize - 1; i++){
                temp = temp.next;
            }
            ListNode next = temp.next;
            temp.next = null;
            temp = next;

        }
        return res;

    }
}
// @lc code=end

