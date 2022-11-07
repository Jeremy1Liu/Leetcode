/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //看的古城算法写的。 
        ListNode sentinal = new ListNode(-1);
        sentinal.next = head;
        ListNode pre = sentinal;
        ListNode cur = sentinal.next;
        //找到需要反转节点之前的最右节点，标记为temp；
        int i=1;
        for(; i<left; i++){
            pre = cur;
            cur = cur.next;
        }

        //pre是1的节点，cur是2的节点；nex是3的节点；
        ListNode node = pre;
        for(; i<=right; i++){
            ListNode nex = cur.next;
            //3指向了2；下一个循环4指向3
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        node.next.next = cur;//把反转区间的2节点指向区间之后的节点5
        node.next = pre;//把反转区间的最后节点接在node.next;

        return sentinal.next;

    }
}
// @lc code=end

