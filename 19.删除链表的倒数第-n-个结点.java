/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //using double pointer can done by scan once.
        ListNode dummy = new ListNode(0,head);
        ListNode temp = dummy;
        ListNode temp2 = head;
        for(int i=0; i < n; i++) temp2 = temp2.next;
        while(temp2 != null){
            temp = temp.next;
            temp2 = temp2.next;

        }
        temp.next = temp.next.next;
        return dummy.next;

    }
}
// @lc code=end

